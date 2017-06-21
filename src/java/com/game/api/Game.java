/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.game.api;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.ejb.Stateless;

/**
 *
 * @author briansarsany
 */
@Stateless
@WebService
public class Game {
    private Board board = new Board();
    private Player white;
    private Player black;
    public Game() {
        super();
    }

    @WebMethod
    public void setColorWhite(Player player) {
        this.white = player;
    }

    @WebMethod
    public void setColorBlack(Player player) {
        this.black = player;
    }

    @WebMethod
    public Board getBoard() {
        return board;
    }

    @WebMethod
    public void setBoard(Board board) {
        this.board = board;
    }

    @WebMethod
    public Player getWhite() {
        return white;
    }

    @WebMethod
    public void setWhite(Player white) {
        this.white = white;
    }

    @WebMethod
    public Player getBlack() {
        return black;
    }

    @WebMethod
    public void setBlack(Player black) {
        this.black = black;
    }

    @WebMethod
    public boolean initializeBoardGivenPlayers() {
        if(this.black == null || this.white == null)
            return false;
        this.board = new Board();
        for(int i=0; i<black.getPieces().size(); i++){
            board.getSpot(black.getPieces().get(i).getX(), black.getPieces().get(i).getY()).occupySpot(black.getPieces().get(i));
        }
        return true;
    }




}
