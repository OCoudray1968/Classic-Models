/**
 * Gestion des fenêtres modales
 * 
 */

let modal = null
const focusableSelector= 'button, a, input, textarea'
let focusables = []
let previouslyFocusElement = null

const openModal = async function (e) {
    e.preventDefault()
    const target = e.target.getAttribute('href')
    if (target.startsWith('#')) {
        modal = document.querySelector(target)
    } else {
        modal = await
        loadModal(target)
    }
    focusables = Array.from(modal.querySelectorAll(focusableSelector))
    previouslyFocusElement = document.querySelector(':focus')
    modal.style.display =null
    focusables[0].focus()
    modal.removeAttribute('aria-hidden')
    modal.setAttribute('aria-modal', 'true')
    modal.addEventListener('click',closeModal)
    modal.querySelector('.js-modal-close').addEventListener('click',closeModal)
    modal.querySelector('.js-modal-stop').addEventListener('click',stopPropagation)
}

const closeModal = function (e) {
    if (modal===null) return
    if(previouslyFocusElement !== null) previouslyFocusElement.focus()
    e.preventDefault()
    modal.setAttribute('aria-hidden',true)
    modal.removeAttribute('aria-modal')
    modal.removeEventListener('click',closeModal)
    modal.querySelector('.js-modal-close').removeEventListener('click',closeModal)
    modal.querySelector('.js-modal-stop').removeEventListener('click',stopPropagation)
    const hideModal = function() {
        modal.style.display = "none"
        modal.removeEventListener('animationend', hideModal)
        modal = null
    }
    modal.addEventListener('animationend', hideModal )
}

const stopPropagation = function (e) {
    e.stopPropagation()
}

const focusModal =  function (e) {
    e.preventDefault()
    let index = focusables.findIndex(f => f === modal.querySelector(':focus'))
    if (e.shiftkey === true){
        index--
    } else {
    index++
    }
    if(index >= focusables.length) {
        index=0
    } 
    if (index < 0) {
        index = focusables.length -1
    }
    focusables[index].focus()
}
document.querySelectorAll('.js-modal').forEach(a => {
    a.addEventListener('click', openModal)
  
})
/** chargement de la fenêtre modale */
const loadModal = async  function (url) {

   const target = '#' + url.split('#')[1]
   const existingModal = document.querySelector(target)
   if(existingModal !== null) return existingModal
   const html = await
   fetch(url).then(response => response.text())
   const element =  document.createRange().createContextualFragment(html).querySelector(target)
   if (element === null) throw "L'élément ${target} n/'a pas été trouvé dans la page ${url}" 
   document.body.append(element)
   return element

}

window.addEventListener('keydown', function(e) {
    if (e.key === "Escape" || e.key === "Esc") {
        closeModal(e)
    }

    if(e.key=== "Tab" && Modal !== null) {
        focusModal(e)
    }
})

/**
 * Gestion du carousel
 */

class Carousel {
    

    /**
     * this callback type is called 'requestCallback' and is displayed as a global symbol.
     * 
     * @callback moveCallback 
     * @param {number} index 
     */

    /**
     * 
     * @param {HTMLElement} element 
     * @param {Object} options 
     * @param {Object} [options.slidesToScroll=1] Nombre d'éléments à faire défiler
     * @param {Object} [options.slidesVisible=1] Nombre d'éléments visible dans un slide
     * @param {boolean} [options.loop=false] Doit on boucler en fin de carousel    
     * @param {boolean} [options.infinite=false] scroll à l'infini
     * @param {boolean} [options.pagination=false]
     * @param {boolean} [options.navigation=true]
     */

    constructor (element, options = {}) {
     
        this.element = element
        this.options = Object.assign({}, {
            slidesToScroll: 1,
            slidesVisible: 1,
            loop: false,
            pagination: false,
            navigation: true,
            infinite: false
        }, options)
        if (this.options.loop && this.options.infinite) {
            throw new Error("un caroussel ne peut être à la fois en boucle et en infini")
        }
        let children = [].slice.call(element.children)
        this.isMobile = false
        this.currentItem = 0
        this.moveCallbacks = []
        this.offset = 0
        // Modification du DOM
        
        this.root = this.createDivWithClass('carousel')
        this.container = this.createDivWithClass('carousel__container')
        this.root.setAttribute('tabindex','0')
        this.root.appendChild(this.container)
        this.element.appendChild(this.root)
        this.items = children.map((child) => {
        let item = this.createDivWithClass('carousel__item')
        item.appendChild(child)
        
        return item
        })
        if (this.options.infinite) {
            this.offset =this.options.slidesVisible + this.options.slidesToScroll 
            if (this.offset > children.length) {
                console.error("Vous n'avez pas assez d'élément dans votre caroussel", element)
            }
            this.items = [ 
                ...this.items.slice(this.items.length - (this.offset)).map(item => item.cloneNode(true)),
                ...this.items,
                ...this.items.slice(0, this.offset).map(item => item.cloneNode(true))
            ]
            this.gotoItem(this.offset, false)
        }
        this.items.forEach(item => this.container.appendChild(item))
        this.setStyle()
        if(this.options.navigation){
            this.createNavigation()
        }
        if(this.options.pagination){
            this.createPagination()
        }
         // Evenements
        this.moveCallbacks.forEach(cb=>cb(this.currentItem))
        this.onWindowResize()
        window.addEventListener('resize', this.onWindowResize.bind(this))
        this.root.addEventListener('keyup', (e) => {
            if (e.key === 'ArrowRight' || e.key === 'Right') {
                this.next()
            } else if (e.key === 'ArrowLeft'|| e.key === 'Left') {
                this.prev()

            }
        })
        if(this.options.infinite) {
        this.container.addEventListener('transitionend',this.resetInfinite.bind(this))
        }
    }
    /**
     * Applique les bonnes dimensions aux  éléments du carousel
     */

    setStyle () {
        let ratio = this.items.length / this.slidesVisible
        this.container.style.width = (ratio * 100) + "%"
        this.items.forEach(item =>  item.style.width =((100 / this.slidesVisible)/ ratio)+"%" )
       
    }
    /**
     * Crée les flêches de navigation
     */

    createNavigation () {
        let nextButton = this.createDivWithClass('carousel__next')
        let prevButton = this.createDivWithClass('carousel__prev')
        this.root.appendChild(nextButton)
        this.root.appendChild(prevButton)
        nextButton.addEventListener('click',this.next.bind(this))
        prevButton.addEventListener('click',this.prev.bind(this))
        if (this.options.loop === true){
            return
        }
        this.onMove(index => {
            
            if(index === 0 ){
               
                prevButton.classList.add('carousel__prev--hidden')
                
            } else {
                prevButton.classList.remove('carousel__prev--hidden')
            }

            if(this.items[this.currentItem + this.slidesVisible]===undefined){

                
                nextButton.classList.add('carousel__next--hidden')
           
            } else {

                nextButton.classList.remove('carousel__next--hidden')
            }
        })
    }
     /**
     * Crée la navigation dans le DOM
     */

    createPagination () {
        let pagination = this.createDivWithClass('carousel__pagination')
        let buttons=[]
        this.root.appendChild(pagination)
        for(let i=0; i< (this.items.length - 2 * this.offset); i= i + this.options.slidesToScroll ){
            let button = this.createDivWithClass('carousel__pagination__button')
            button.addEventListener('click',() => this.gotoItem(i + this.offset))
            pagination.appendChild(button)
            buttons.push(button)
        }
        this.onMove(index => {
            let count = this.items.length - 2 * this.offset
           let activeButton = buttons[Math.floor(((index - this.offset)%count)/ this.options.slidesToScroll)]
           if (activeButton){
               buttons.forEach(button => button.classList.remove('carousel__pagination__button--active'))
               activeButton.classList.add('carousel__pagination__button--active')
           }
        })

    }
    next () {
        this.gotoItem(this.currentItem + this.slidesToScroll)

    }

    prev () {

        this.gotoItem(this.currentItem - this.slidesToScroll)


    }
    /**
     * Déplace le carousel vers l'élément ciblé
     * @param {number} index 
     * @param {boolean} [animation=true]
     */
    gotoItem (index, animation = true) {
            
            if (index <  0) {
            if (this.options.loop){
                index = this.items.length - this.slidesVisible
            } else {
                return
            }
           index = this.items.length - this.options.slidesVisible
        } else if (index >= this.items.length || (this.items[this.currentItem + this.options.slidesVisible]===undefined && index >
            this.currentItem)){
                if (this.options.loop) {
                    index = 0 
                } else {
                    return
                }
            index = 0
        }
        let translateX =  index * - 100 / this.items.length 
        if (animation==false) {
            this.container.style.transition ='none'
        }
        this.container.style.transform = 'translate3d(' + translateX +'%, 0, 0)'
        this.container.offsetHeight //force le repaint
        if(animation === false) {
            this.container.style.transition = ''
        }
        this.currentItem = index
        this.moveCallbacks.forEach(cb => cb(index))

    }
    /**
     * déplace le container pour donner l'impréssion d'un slide infini
     */
    resetInfinite() {
        if(this.currentItem <= this.options.slidesToScroll) {
            this.gotoItem(this.currentItem + this.items.length - (2 * this.offset), false)
        } else if (this.currentItem >= this.items.length - this.offset) {
            this.gotoItem(this.currentItem -(this.items.length - 2 * this.offset), false)
        }
    }
    /**
     * @param {moveCallback} cb...*/

    onMove(cb) {
        this.moveCallbacks.push(cb)
    }
 
    onWindowResize() {
        let mobile = window.innerWidth < 800
        if (mobile !== this.isMobile) {
            this.isMobile = mobile
            this.setStyle()
            this.moveCallbacks.forEach(cb=>cb(this.currentItem))
    
        }
    }
 
    /**
     * 
     * @param {string} className
     * @returns {HTMLElement} 
     */
    createDivWithClass (className) {
        let div = document.createElement('div')
        div.setAttribute('class', className)
        return div
    }

    /**
     * 
     * @returns {number}
     */
    get slidesToScroll () {
        return this.isMobile ? 1 : this.options.slidesToScroll
    }
    /**
     * 
     * @returns {number}
     */
    get slidesVisible () {
        return this.isMobile ? 1 : this.options.slidesVisible
    }
}

let onReady = function () {
    
    new Carousel(document.querySelector('#carousel1'), {
        slidesVisible: 3,
        slidesToScroll: 2,
        infinite: true,
        pagination:true
                   
        })

    }

    if (document.readyState !== 'loading') {
        onReady()
    }
 
document.addEventListener('DOMContentLoaded', onReady )


