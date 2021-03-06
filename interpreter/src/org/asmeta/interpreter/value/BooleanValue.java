/*
 * BooleanValue.java
 *
 * Created on 23 maggio 2006, 14.18
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package org.asmeta.interpreter.value;

import asmeta.terms.basicterms.BooleanTerm;

/**
 * A boolean value.
 * 
 */
public class BooleanValue extends Value {
	
	
	/**
	 * The constant True. 
	 */
	public static final BooleanValue TRUE = new BooleanValue(true);
	
	/**
	 * The constant False. 
	 */
	public static final BooleanValue FALSE = new BooleanValue(false);
	
	/**
	 * The value.
	 */
	private boolean boolValue;
    

    /**
     * Creates a new boolean.
     * 
     * @param bool a boolean value
     */
    private BooleanValue(boolean bool) {
        boolValue = bool;
    }

    /**
     * Creates a new boolean.
     * 
     * @param term a boolean term
     */
    static public BooleanValue parseBooleanValue(BooleanTerm term) {
        return parserBooleanValue(term.getSymbol());
    }
    
    /**
     * Gets a boolean value.
     * 
     * @param bvalue a boolean value
     * @return the same value
     */
    static public BooleanValue parseBooleanValue(boolean bvalue) {
    	if (bvalue) return TRUE;
        else return FALSE;
    }
    
    /**
     * Parses a string and convert it into a boolean value.
     * 
     * @param value a string
     */
    static public BooleanValue parserBooleanValue(String value) {
        boolean bvalue = Boolean.parseBoolean(value);
        return parseBooleanValue(bvalue);
    }
        
    /**
     * Gets the value.
     * 
     * @return the value
     */
    public boolean getValue() {
        return boolValue;
    }
    
	@Override
	public int hashCode() {
		return getValue() ? 1 : 0;
	}
	
    @Override
	public boolean equals(Object object) {
        if (object instanceof BooleanValue) {
            return getValue() == ((BooleanValue) object).getValue();
        }
        //PA 19/02/10
        else if (object instanceof UndefValue) {
        	return false;
        }
        throw new IllegalArgumentException();
    }
    
    @Override
	public String toString() {
        return Boolean.toString(getValue());
    }

    //PA: 14 giugno 10
	@Override
	public Value clone() {
		return new BooleanValue(boolValue);
	}
}
