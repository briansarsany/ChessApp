/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.game.api;

import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebService;


/**
 *
 * @author briansarsany
 */
@WebService
@Stateless
public class Piece {
    private boolean available;
    private int x;
    private int y;

    public Piece() {
        super();
    }

    public Piece(boolean available, int x, int y) {
        super();
        this.available = available;
        this.x = x;
        this.y = y;
    }

    @WebMethod
    public boolean isAvailable() {
        return available;
    }
    @WebMethod
    public void setAvailable(boolean available) {
        this.available = available;
    }
    @WebMethod
    public int getX() {
        return x;
    }
    @WebMethod
    public void setX(int x) {
        this.x = x;
    }
    @WebMethod
    public int getY() {
        return y;
    }
    @WebMethod
    public void setY(int y) {
        this.y = y;
    }

    public boolean isValid(Board board, int fromX, int fromY, int toX, int toY){
        if(toX == fromX && toY == fromY)
            return false; //cannot move nothing
        if(toX < 0 || toX > 7 || fromX < 0 || fromX > 7 || toY < 0 || toY > 7 || fromY <0 || fromY > 7)
            return false;
        return true;
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
