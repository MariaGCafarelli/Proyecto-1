/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grafo;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;

/**
 *
 * @author SamuelLMiller
 */
public class Labyrinth extends JFrame{
    private Vertice[][] maze;
    
    public Labyrinth(Vertice[][] maze) {
        this.maze = maze;
        setTitle("Recorrido de una hormiga");
        setSize(500, 280);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        /*p = new PlayerMove();
        addKeyListener(new Al());
        setFocusable(true);*/
        
    }

    /*public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void setSize(int size) {
        this.size = size;
    }*/
    
    /*public void genLab(){
        for (int row = 1; row < maze.length; row++) {
            for (int col = 1; col < maze[0].length; col++) {
                if(maze[row][col] == 0){
                    
                    
                    
                    //Monstruos normales
                    float random_1 = (float)(Math.random() * 100 + 1);
                    if (random_1 <= 7.5){
                        maze[row][col] = 3;
                    }
                    
                    //Objetos
                    float random_4 = (float)(Math.random() * 100 + 1);
                    if (random_4 <= 0.5){
                        int random_5 = (int)(Math.random() * 10 + 1);
                        //Pócimas
                        if(random_5 < 8){
                            maze[row][col] = 6;
                        }
                        //Picos
                        else{
                            maze[row][col] = 7;
                        }
                    }
                    
                    if((maze[row][col-1] == 1 && maze[row][col+1] == 1 && (maze[row-1][col] == 1 || maze[row+1][col] == 1)) || (maze[row-1][col] == 1 && maze[row+1][col] == 1 && (maze[row][col-1] == 1 || maze[row][col+1] == 1))){
                        int random_5 = (int)(Math.random() * 10 + 1);
                        //Pócimas
                        if(random_5 < 8){
                            maze[row][col] = 6;
                        }
                        //Picos
                        else{
                            maze[row][col] = 7;
                        }
                    }
                   
                    
                    //Magos
                    if ((maze[row-1][col] == 0 && maze[row][col-1] == 0 && maze[row+1][col] == 1 && maze[row][col+1] == 1) || (maze[row+1][col] == 0 && maze[row][col-1] == 0 && maze[row-1][col] == 1 && maze[row][col+1] == 1) || (maze[row-1][col] == 0 && maze[row][col+1] == 0 && maze[row+1][col] == 1 && maze[row][col-1] == 1) || (maze[row+1][col] == 0 && maze[row][col+1] == 0 && maze[row-1][col] == 1 && maze[row][col-1] == 1)){
                        int random_2 = (int)(Math.random() * 100 + 1);
                        if (random_2 <= 5){
                            maze[row][col] = 4;
                        }
                    }
                    
                    //Guerreros
                    if((maze[row-1][col] == 0 && maze[row+1][col] == 0 && maze[row][col-1] == 0 && maze[row][col+1] == 0) || (maze[row][col-1] == 1 && maze[row][col+1] == 0 && maze[row-1][col] == 0 && maze[row+1][col] == 0) || (maze[row][col+1] == 1 && maze[row][col-1] == 0 && maze[row-1][col] == 0 && maze[row+1][col] == 0) || (maze[row+1][col] == 1 && maze[row-1][col] == 0 && maze[row][col-1] == 0 && maze[row][col+1] == 0) || (maze[row-1][col] == 1 && maze[row+1][col] == 0 && maze[row][col-1] == 0 && maze[row][col+1] == 0)){
                        int random_3 = (int)(Math.random() * 4 + 1);
                        if (random_3 < 2){
                            maze[row][col] = 5;
                        }
                    }
                }
            }
        }
        
        //Creación de la matriz
        int[][] labyrinth = new int[10][10];*/
        
        //Laberinto sin paredes
        /*for (int i = 0; i < labyrinth.length; i++) {
            for (int j = 0; j < labyrinth.length; j++) {
                labyrinth[i][j] = 0;
            }
        }*/
        
        /*
        //Definir la entrada (2)
        int random1 = (int)(Math.random() * (10 - 1) + 1);
        labyrinth[random1][1] = 2;
        
        //Definir la salida (9)
        int random2 = (int)(Math.random() * (10 - 1) + 1);
        labyrinth[random2][13 - 1] = 9;
        
        //Rellenar la columna de la entrada con paredes
        for (int i = 0; i < labyrinth.length; i++) {
            if (i == random1){
                continue;
            }
            else{
                labyrinth[i][0] = 1;
            }
        }
        
        //Rellenar la columna de la salida con paredes
        for (int i = 0; i < labyrinth.length; i++) {
            if (i == random2){
                continue;
            }
            else{
                labyrinth[i][0] = 1;
            }
        }
        
        //Rellenar el resto de los bordes con paredes
        for (int i = 0; i < labyrinth.length; i++) {
            labyrinth[0][i] = 1;
        }
        for (int i = 0; i < labyrinth.length; i++) {
            labyrinth[labyrinth.length - 1][i] = 1;
        }
        */
        
        /*for (int i = 0; i < labyrinth.length; i++) {
            for (int j = 0; j < labyrinth.length; j++) {
                System.out.print(labyrinth[i][j] + "\t");
            }
            System.out.println("");
        }*/
            
    //}
            @Override
    
            public void paint(Graphics g){
                super.paint(g);

                for (int row = 0; row < maze.length; row++) {
                    for (int col = 0; col < maze[0].length; col++) {
                        Color color;
                        switch (maze[row][col].getColor()){
                            case 1:
                                color = Color.BLACK;
                                break;
                            case 2:
                                color = Color.CYAN;
                                break;
                            case 3:
                                color =Color.ORANGE;
                                break;
                            case 4:
                                color = Color.PINK;
                                break;
                            case 5:
                                color = Color.LIGHT_GRAY;
                                break;
                            case 6:
                                color = Color.MAGENTA;
                                break;
                            case 7: 
                                color = Color.CYAN;
                                break;
                            case 22:
                                color = Color.RED;
                                break;
                            case 12:
                                color = Color.GREEN;
                                break;
                            default:
                                color = Color.WHITE;

                        }
                        
                        g.setColor(color);
                        g.fillRect(39 * col, 15 * row, 50, 50);
                        //g.setColor(Color.BLACK);
                        //g.drawRect(30 * col, 30 * row, 30, 30);
                    }

                }
            }
            
}
