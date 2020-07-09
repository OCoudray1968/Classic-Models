package com.classicModels.DAO;

public class DAOConfigurationException extends RuntimeException {
    /**
	 * renvoie des messages d'erreurs
	 */
	private static final long serialVersionUID = 1L;

	/*
     * Constructeurs
     */
    public DAOConfigurationException( String message ) {
        super( message );
    }

    public DAOConfigurationException( String message, Throwable cause ) {
        super( message, cause );
    }

    public DAOConfigurationException( Throwable cause ) {
        super( cause );
    }
}
