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
public class Spot {
    int x;
    int y;
    Piece piece;
    public Spot() {
        super();
    }

    public Spot(int x, int y) {
        super();
        this.x = x;
        this.y = y;
        piece = null;
    }

    @WebMethod
    public void occupySpot(Piece piece){
        //if piece already here, delete it, i. e. set it dead
        if(this.piece != null)
            this.piece.setAvailable(false);
        //place piece here
        this.piece = piece;
    }

    @WebMethod
    public boolean isOccupied() {
        if(piece != null)
            return true;
        return false;
    }

    @WebMethod
    public Piece releaseSpot() {
        Piece releasedPiece = this.piece;
        this.piece = null;
        return releasedPiece;
    }    

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
