
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JButton;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author saadm
 */
public class sudokuForm extends javax.swing.JFrame {
    boolean oneR1;
    int xx;
    int yy;
    int solution = 0;
    boolean clicked = false;



private int[][] sudoku = {{0,0,0,0,0,0,0,0,0},
                             {0,0,0,0,0,0,0,0,0},
                             {0,0,0,0,0,0,0,0,0},
                             {0,0,0,0,0,0,0,0,0},
                             {0,0,0,0,0,0,0,0,0},
                             {0,0,0,0,0,0,0,0,0},
                             {0,0,0,0,0,0,0,0,0},
                             {0,0,0,0,0,0,0,0,0},
                             {0,0,0,0,0,0,0,0,0}};

private int[][] problem = {{0,0,0,0,0,0,0,0,0},
                             {0,0,0,0,0,0,0,0,0},
                             {0,0,0,0,0,0,0,0,0},
                             {0,0,0,0,0,0,0,0,0},
                             {0,0,0,0,0,0,0,0,0},
                             {0,0,0,0,0,0,0,0,0},
                             {0,0,0,0,0,0,0,0,0},
                             {0,0,0,0,0,0,0,0,0},
                             {0,0,0,0,0,0,0,0,0}};

    private JButton[][] squares;
    private JButton[] numbers;
    private Color[] colors;
    private ActionListener listener, listenerAct;
    /**
     * Creates new form sudokuForm
     */
    public sudokuForm() {
        Container cp = getContentPane();
        cp.setLayout(new GridLayout(10,9));
        
        colors = new Color[2];
        colors[0] = Color.decode("#CDCDCD");
        colors[1] = Color.decode("#808080");
        
        squares = new JButton[9][9];
        
        numbers = new JButton[10];
        
        for(int i = 0; i<9; i++){
            for(int j = 0; j<9; j++){
                squares[i][j] = new JButton();
               
                squares[i][j].addActionListener(new myActionListener());
                if(i<3 && j<3){
                   squares[i][j].setBackground(colors[0]);
                   
               } else if(i < 3 && j > 2 && j < 6 ){
                   
                   squares[i][j].setBackground(colors[1]);
                   
               } else if(i <3&& j > 5 && j < 9) {
                   squares[i][j].setBackground(colors[0]);
               } else if(i > 2 && i<6 && j > 5 && j < 9) {
                   squares[i][j].setBackground(colors[1]);
               } 
                else if(i > 2 && i<6 && j > 2 && j < 6) {
                   squares[i][j].setBackground(colors[0]);
               } else if(i > 2 && i<6 && j<3) {
                   squares[i][j].setBackground(colors[1]);
               } else if(i > 5 && i<9 && j > 2 && j < 6) {
                   squares[i][j].setBackground(colors[1]);
               }
                else if(i > 5 && i<9 && j > 5 && j < 9) {
                   squares[i][j].setBackground(colors[0]);
               }
                else if(i > 5 && i<9 && j <3) {
                   squares[i][j].setBackground(colors[0]);
               }
                
                
                 cp.add(squares[i][j]);
            }
            
        }
        for(int i = 0; i<9; i++){
            numbers[i] = new JButton();
            numbers[i].addActionListener(new kyActionListener());
            numbers[i].setBackground(Color.ORANGE);
            cp.add(numbers[i]);
        }
        int[] num = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        
        for(int i = 0; i < 9; i++){
            numbers[i].setText(Integer.toString(num[i]));
        }
        
        
        
        int row = 0;
        int column = 0;
        //solve(row,column);
        
        
       
       // solve();
        
        
            
           
        
        
       for(int i = 0; i < 9; i++){
           for(int j = 0; j<9; j++){
               solveMe(i, j);
               
           }
       }
       createHard();
     
       
      
      
        for(int i = 0; i < 9;i++){
            for (int j = 0; j < 9; j++){
                if(problem[i][j] != 0){
                        squares[i][j].setText(Integer.toString(problem[i][j]));
                
                }
            }
        }
        
       
        
     
        
       cp.setPreferredSize(new Dimension(500,500));
        pack();
        
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 431, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 357, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(sudokuForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(sudokuForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(sudokuForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(sudokuForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new sudokuForm().setVisible(true);
            }
        });
    }

    public  class kyActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            JButton button = (JButton) ae.getSource();
            if(clicked == true){
                int i = (int) button.getClientProperty("col");
                i++;
                int x = problem[xx][yy];
                if(x == 0){
                    squares[xx][yy].setText(Integer.toString(i));
                }
            }
        }

       
    }

    
 
      public  class myActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
                JButton button = (JButton) ae.getSource();
                if(clicked == false){
                    int i = (int) button.getClientProperty("col");
                    int j = (int) button.getClientProperty("row");
                    xx = i;
                    yy = j;
                    clicked = true;
                    
                } 
        }

        }
    private boolean solve() {
            
        for(int x = 0; x<9; x++){
            for(int y = 0; y < 9; y++){
                if(sudoku[x][y] == 0){
                    
                   for(int n = 1; n<=9;n++){
                       Random rand = new Random();
                       int k = rand.nextInt(9)+1;
                       if(isOk(x, y, k)){
                           sudoku[x][y] = k;
                           solution =1;
                           if(solve()){
                               solution++;
                               return true;
                           } else {
                               solution = 0;
                               sudoku[x][y] = 0;
                           }
                       }
                   }
                   return false;
                }
            }
        }
        return true;
    }
    
    private boolean Solve(int i, int  j){
        if(sudoku[i][j] == 0 ){
            for(int n = 1; n<=9; n++){
                Random rand = new Random();
                int k = rand.nextInt(9)+1;
                if(isOk(i,j,k)){
                    if(Solve(i, j)){
                        return true;
                    } else {
                        return false;
                    }
                }
            }
        }
        return true;
    }

     private void createHard(){
        Random rand = new Random();
        int x = 0;
        int m;
        problem = sudoku;
        while(x<=60){
            int k = rand.nextInt(9)+0;
            int f = rand.nextInt(9)+0;
            m = sudoku[k][f];
            sudoku[k][f] = 0;
            if(Solve(k,f)){
                int y = 0;
                for(int i = 0; i<9; i++){
                    for(int j = 0; j<9; j++){
                        if(problem[i][j] == m){
                            y++;
                           
                        }
                    }
                }
                if(y >=3){
                     problem[k][f] = 0;
                    y--;
                    x++;
                }
            }
        }
    }
     private void createMedium(){
        Random rand = new Random();
        int x = 0;
        int m;
        problem = sudoku;
        while(x<50){
            int k = rand.nextInt(9)+0;
            int f = rand.nextInt(9)+0;
            m = sudoku[k][f];
            sudoku[k][f] = 0;
            if(Solve(k,f)){
                int y = 0;
                for(int i = 0; i<9; i++){
                    for(int j = 0; j<9; j++){
                        if(problem[i][j] == m){
                            y++;
                           
                        }
                    }
                }
                if(y >=4){
                     problem[k][f] = 0;
                    y--;
                    x++;
                }
            }
        }
    }
     
    private void createEasy(){
        Random rand = new Random();
        int x = 0;
        int m;
        problem = sudoku;
        while(x<45){
            int k = rand.nextInt(9)+0;
            int f = rand.nextInt(9)+0;
            m = sudoku[k][f];
            sudoku[k][f] = 0;
            if(Solve(k,f)){
                int y = 0;
                for(int i = 0; i<9; i++){
                    for(int j = 0; j<9; j++){
                        if(problem[i][j] == m){
                            y++;
                           
                        }
                    }
                }
                if(y >=5){
                     problem[k][f] = 0;
                    y--;
                    x++;
                }
            }
        }
    }
    private void create(){
        Random rand = new Random();
        int x = 0;
       problem = sudoku;
        while(x < 54){
                int k = rand.nextInt(9)+0;
                int f = rand.nextInt(9)+0;
                sudoku[k][f] = 0;
                if(Solve(k,f)){

                    problem[k][f] = 0;
                    
                    x++;
                } 
                    
               
                
                
        }
        
        
    }
    
    private boolean solveMe(int x, int y){
        for(int i = 1; i<=9;i++){
            
            if(sudoku[x][y] == 0){
               Random rand = new Random(); 
               int k = rand.nextInt(9)+1;
               if(isOk(x, y, k)){
                   sudoku[x][y] = k;
                   if(solve()){
                       return true;
                   }
               }
            }else{
                return false;
            }
        }
        return true;
    }

            
            
    private boolean isOk(int row, int col, int number){
        return rowCheck(row, number) && ColumnCheck(col, number) && squareCheck(row, col, number);
    }

    private boolean rowCheck(int row, int x) {
      for (int i = 0; i < 9; i++){
          if(sudoku[row][i] == x){
              return false;
          }
      }  
      return true;
    }

    private boolean ColumnCheck(int column, int x) {
        for(int i = 0; i < 9; i++){
            if(sudoku[i][column] == x){
                return false;
            }
        }
        return true;
    }
    

    private boolean squareCheck(int row, int column, int x) {
        int[][] square = new int[3][3];
        square = getSquare(row, column);
        for(int i = 0; i<3; i++){
            for(int j = 0; j<3; j++){
                if(square[i][j] == x){
                    return false;
                }
            }
        }
        return true;
    }

  

  
    private int[][] getSquare(int row, int column) {
        int[][] square = new int[3][3];
       int x = 3*(row/3);
       int y = 3*(column/3);
       
       for(int i = 0; i<3; i++){
           for(int j = 0; j<3; j++){
               square[i][j] = sudoku[x+i][y+j];
           }
       }
       return square;
    }
  private boolean checkIfEmpty() {
        for (int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                if(sudoku[i][j] == 0){
                    return false;
                }
            }
        }
        return true;
    }
    
    private boolean checkif(){
        for(int x = 0; x<9; x++){
            for(int y = 0; y < 9; y++){
                if(problem[x][y] == 0){
                    
                   for(int n = 1; n<=9;n++){
                       Random rand = new Random();
                       int k = rand.nextInt(9)+1;
                       if(isOk(x, y, k)){
                           problem[x][y] = k;
                           solution =1;
                           if(checkif()){
                               solution++;
                               return true;
                           } else {
                               solution = 0;
                               problem[x][y] = 0;
                           }
                       }
                   }
                   return false;
                }
            }
        }
        return true;
    }
    
        

    private boolean stillEmpty() {
        for (int i = 0; i<9;i++){
            for(int j = 0; j<9; j++){
                if(sudoku[i][j]== 0){
                    return true;
                }
               
        }
             
    }
           return false;
    }
}

   /* private boolean create() {
        int m = 0;
        while(m < 10){
     Random rand = new Random();
     int x = rand.nextInt(8)+0;
          int y = rand.nextInt(8)+0;

        problem[x][y] = 0;
        checkif();
        
        if(solution == 1){
            
            m++;
            
        } 
    }
        return true;
    }*/

  
        
               
     /*   Random rand = new Random();
        boolean numberFound = false;
        
        ArrayList<Integer> numbers = new ArrayList<Integer>();
        
        for (int i = 1; i < 10; i++){
            numbers.add(i);
        }
        
        while( numberFound == false) {
            int x = numbers.get(rand.nextInt(numbers.size()));
            
            if(rowCheck(row, x) && ColumnCheck(column, x) && squareCheck(row, column, x)){
                
                sudoku[row][column] = x;
                squares[row][column].setText(Integer.toString(x));
                numberFound = true;
                break;
            }else{
                numbers.remove(Integer.valueOf(x));
                
                if(numbers.isEmpty()){
                    break;
                }
            }
            
        }*/
      /*  private int[][] sudoku = {{9,0,0,1,0,0,0,0,5},
                             {0,0,5,0,9,0,2,0,1},
                             {8,0,0,0,4,0,0,0,0},
                             {0,0,0,0,8,0,0,0,0},
                             {0,0,0,7,0,0,0,0,0},
                             {0,0,0,0,2,6,0,0,9},
                             {2,0,0,3,0,0,0,0,6},
                             {0,0,0,2,0,0,9,0,0},
                             {0,0,1,9,0,4,5,7,0}};
    */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

  /*  private boolean solveIT(){
         for(int x = 0; x<9; x++){
             for(int y = 0; y<9; y++){
                if(sudoku[x][y]== 0){
                    for(int n = 1; n<=9; n++){
                        if(isOk(x, y, n)){
                            return true;
                        }if(solveIT()){
                            return true;
                        }else{
                            sudoku[x][]
                        }
                    }
                }
             }
         }
    } private void createEasy(){
        Random rand = new Random();
        int x = 0;
        int m;
        problem = sudoku;
        while(x<45){
            int k = rand.nextInt(9)+0;
            int f = rand.nextInt(9)+0;
            m = sudoku[k][f];
            sudoku[k][f] = 0;
            if(Solve(k,f)){
                int y = 0;
                for(int i = 0; i<9; i++){
                    for(int j = 0; j<9; j++){
                        if(problem[i][j] == m){
                            y++;
                           
                        }
                    }
                }
                if(y >=5){
                     problem[k][f] = 0;
                    y--;
                    x++;
                }
            }
    */
/*private int[][] sudoku =    {{0,2,0,0,0,8,0,0,7},
                             {0,0,0,6,0,0,1,0,8},
                             {0,0,0,0,0,3,0,9,4},
                             {0,0,0,0,4,0,8,6,3},
                             {0,0,9,0,0,0,7,4,0},
                             {4,8,0,0,7,0,0,0,0},
                             {9,3,0,5,0,0,0,8,0},
                             {8,0,2,0,0,1,0,0,0},
                             {0,0,0,2,8,0,0,7,0}};*/