# DropToken

## How to compile and run the game
The game is written in Java to use a command-line interface.
1. Clone the repo
2. In the src folder run this command from terminal:  
``` > javac DropTokenMain.java ```
3. Now the class files have been compiled. Run the program with:  
```> java DropTokenMain```  
Note: You need to have Java 8 or greater installed to play


##Description
Drop Token takes place on a 4x4 grid. A token is dropped along a
column (labeled 1-4) and said token goes to the lowest unoccupied
row of the board. A player wins when they have 4 tokens next to each
other either along a row, in a column, or on a diagonal. If the board is
filled, and nobody has won then the game is a draw. Each player takes
a turn, starting with player 1, until the game reaches either win or
draw. If a player tries to put a token in a column that is already full, that
results in an error state, and the player must play again until the play a
valid move.

## Interface
CLI that loops over stdIn taking commands, and prints out responses
based on those commands.  

#### Commands include:    
PUT <column> (OK | ERROR | WIN | DRAW)  
GET list of ordered moves made to each column  
BOARD a 4x4 matrix that shows the board state:  

    | 0 0 0 0  
    | 0 0 0 0  
    | 2 2 0 0  
    | 1 1 1 2  
    +--------  
     1 2 3 4  
    Where 0 is unfilled, 1 is player 1, and 2 is player 2.  

EXIT ends the program.




## Example game  
Lines prefixed with > indicate input from the user(s). All other lines are
output from the program.  
>$ GET  
>$ BOARD  
| 0 0 0 0  
| 0 0 0 0  
| 0 0 0 0  
| 0 0 0 0  
+--------  
 1 2 3 4  
>$ PUT 1  
OK  
>$ PUT 4  
OK  
>$ PUT 2  
OK  
>$ PUT 3  
OK  
>$ BOARD  
| 0 0 0 0  
| 0 0 0 0  
| 0 0 0 0  
| 1 1 2 2  
+--------  
 1 2 3 4  
>$ PUT 1  
OK  
>$ PUT 1  
OK  
>$ PUT 1  
OK  
>$ PUT 1   
ERROR  
>$ BOARD  
| 1 0 0 0  
| 2 0 0 0  
| 1 0 0 0  
| 1 1 2 2  
+--------  
 1 2 3 4  
>$ PUT 3  
OK  
>$ PUT 2  
OK  
>$ PUT 3  
OK  
>$ PUT 2  
OK  
>$ PUT 3  
WIN  
>$ BOARD  
| 1 0 2 0  
| 2 1 2 0  
| 1 1 2 0  
| 1 1 2 2  
+--------  
 1 2 3 4  
>$ GET  
1  
4  
2  
3  
1  
1  
1  
3  
2  
3  
2  
3  
>$ EXIT  
