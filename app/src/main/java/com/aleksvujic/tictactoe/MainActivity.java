package com.aleksvujic.tictactoe;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private int[][] mreza = new int[3][3]; // 1=krizec, 2=krozec
    private int poteza = 1;
    private int stSimbolov = 0;
    private boolean konecIgre = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void reset(View v) {
        this.konecIgre = false;
        resetBoard(-1);
    }

    public void clearButtons() {
        TextView info = findViewById(R.id.gameInfo);
        info.setText("");

        Button button = findViewById(R.id.polje11);
        button.setText("");

        button = findViewById(R.id.polje12);
        button.setText("");

        button = findViewById(R.id.polje13);
        button.setText("");

        button = findViewById(R.id.polje21);
        button.setText("");

        button = findViewById(R.id.polje22);
        button.setText("");

        button = findViewById(R.id.polje23);
        button.setText("");

        button = findViewById(R.id.polje31);
        button.setText("");

        button = findViewById(R.id.polje32);
        button.setText("");

        button = findViewById(R.id.polje33);
        button.setText("");
    }

    private void resetBoard(int zmagovalec) {
        this.mreza = new int[3][3];
        this.poteza = 1;
        this.stSimbolov = 0;

        if (zmagovalec == -1) {
            clearButtons();
            resetColor();
            return;
        }

        String tekst;
        if (zmagovalec == 0) {
            tekst = "It's a tie!";
        } else {
            String player;
            if (zmagovalec == 1) {
                player = "X";
            } else {
                player = "O";
            }
            tekst = "Winner is " + player + "!";
        }

        TextView info = findViewById(R.id.gameInfo);
        info.setText(tekst);
    }

    private boolean win() {
        if (this.mreza[0][0] == 1 && this.mreza[0][1] == 1 && this.mreza[0][2] == 1 ||
                this.mreza[0][0] == 2 && this.mreza[0][1] == 2 && this.mreza[0][2] == 2 ||
                this.mreza[0][0] == 1 && this.mreza[1][0] == 1 && this.mreza[2][0] == 1 ||
                this.mreza[0][0] == 2 && this.mreza[1][0] == 2 && this.mreza[2][0] == 2 ||
                this.mreza[0][0] == 1 && this.mreza[1][1] == 1 && this.mreza[2][2] == 1 ||
                this.mreza[0][0] == 2 && this.mreza[1][1] == 2 && this.mreza[2][2] == 2 ||
                this.mreza[1][0] == 1 && this.mreza[1][1] == 1 && this.mreza[1][2] == 1 ||
                this.mreza[1][0] == 2 && this.mreza[1][1] == 2 && this.mreza[1][2] == 2 ||
                this.mreza[2][0] == 1 && this.mreza[2][1] == 1 && this.mreza[2][2] == 1 ||
                this.mreza[2][0] == 2 && this.mreza[2][1] == 2 && this.mreza[2][2] == 2 ||
                this.mreza[2][0] == 1 && this.mreza[1][1] == 1 && this.mreza[0][2] == 1 ||
                this.mreza[2][0] == 2 && this.mreza[1][1] == 2 && this.mreza[0][2] == 2 ||
                this.mreza[0][1] == 1 && this.mreza[1][1] == 1 && this.mreza[2][1] == 1 ||
                this.mreza[0][1] == 2 && this.mreza[1][1] == 2 && this.mreza[2][1] == 2 ||
                this.mreza[0][2] == 1 && this.mreza[1][2] == 1 && this.mreza[2][2] == 1 ||
                this.mreza[0][2] == 2 && this.mreza[1][2] == 2 && this.mreza[2][2] == 2) {

            if (this.mreza[0][0] == 1 && this.mreza[0][1] == 1 && this.mreza[0][2] == 1) {
                changeColor(11, 12, 13);
            } else if (this.mreza[0][0] == 2 && this.mreza[0][1] == 2 && this.mreza[0][2] == 2) {
                changeColor(11, 12, 13);
            } else if (this.mreza[0][0] == 1 && this.mreza[1][0] == 1 && this.mreza[2][0] == 1) {
                changeColor(11, 21, 31);
            } else if (this.mreza[0][0] == 2 && this.mreza[1][0] == 2 && this.mreza[2][0] == 2) {
                changeColor(11, 21, 31);
            } else if (this.mreza[0][0] == 1 && this.mreza[1][1] == 1 && this.mreza[2][2] == 1) {
                changeColor(11, 22, 33);
            } else if (this.mreza[0][0] == 2 && this.mreza[1][1] == 2 && this.mreza[2][2] == 2) {
                changeColor(11, 22, 33);
            } else if (this.mreza[1][0] == 1 && this.mreza[1][1] == 1 && this.mreza[1][2] == 1) {
                changeColor(21, 22, 23);
            } else if (this.mreza[1][0] == 2 && this.mreza[1][1] == 2 && this.mreza[1][2] == 2) {
                changeColor(21, 22, 23);
            } else if (this.mreza[2][0] == 1 && this.mreza[2][1] == 1 && this.mreza[2][2] == 1) {
                changeColor(31, 32, 33);
            } else if (this.mreza[2][0] == 2 && this.mreza[2][1] == 2 && this.mreza[2][2] == 2) {
                changeColor(31, 32, 33);
            } else if (this.mreza[2][0] == 1 && this.mreza[1][1] == 1 && this.mreza[0][2] == 1) {
                changeColor(31, 22, 13);
            } else if (this.mreza[2][0] == 2 && this.mreza[1][1] == 2 && this.mreza[0][2] == 2) {
                changeColor(31, 22, 13);
            } else if (this.mreza[0][1] == 1 && this.mreza[1][1] == 1 && this.mreza[2][1] == 1) {
                changeColor(12, 22, 32);
            } else if (this.mreza[0][1] == 2 && this.mreza[1][1] == 2 && this.mreza[2][1] == 2) {
                changeColor(12, 22, 32);
            } else if (this.mreza[0][2] == 1 && this.mreza[1][2] == 1 && this.mreza[2][2] == 1) {
                changeColor(13, 23, 33);
            } else if (this.mreza[0][2] == 2 && this.mreza[1][2] == 2 && this.mreza[2][2] == 2) {
                changeColor(13, 23, 33);
            }

            this.konecIgre = true;
            return true;
        }
        return false;
    }

    private void resetColor() {
        Button button = findViewById(R.id.polje11);
        button.setTextColor(Color.parseColor("#0146B5"));

        button = findViewById(R.id.polje12);
        button.setTextColor(Color.parseColor("#0146B5"));

        button = findViewById(R.id.polje13);
        button.setTextColor(Color.parseColor("#0146B5"));

        button = findViewById(R.id.polje21);
        button.setTextColor(Color.parseColor("#0146B5"));

        button = findViewById(R.id.polje22);
        button.setTextColor(Color.parseColor("#0146B5"));

        button = findViewById(R.id.polje23);
        button.setTextColor(Color.parseColor("#0146B5"));

        button = findViewById(R.id.polje31);
        button.setTextColor(Color.parseColor("#0146B5"));

        button = findViewById(R.id.polje32);
        button.setTextColor(Color.parseColor("#0146B5"));

        button = findViewById(R.id.polje33);
        button.setTextColor(Color.parseColor("#0146B5"));
    }

    private void changeColor(int a, int b, int c) {
        if (a == 11) {
            Button button = findViewById(R.id.polje11);
            button.setTextColor(Color.parseColor("#E01ADD"));
        } else if (a == 21) {
            Button button = findViewById(R.id.polje21);
            button.setTextColor(Color.parseColor("#E01ADD"));
        } else if (a == 31) {
            Button button = findViewById(R.id.polje31);
            button.setTextColor(Color.parseColor("#E01ADD"));
        } else if (a == 12) {
            Button button = findViewById(R.id.polje12);
            button.setTextColor(Color.parseColor("#E01ADD"));
        } else if (a == 13) {
            Button button = findViewById(R.id.polje13);
            button.setTextColor(Color.parseColor("#E01ADD"));
        }

        if (b == 12) {
            Button button = findViewById(R.id.polje12);
            button.setTextColor(Color.parseColor("#E01ADD"));
        } else if (b == 21) {
            Button button = findViewById(R.id.polje21);
            button.setTextColor(Color.parseColor("#E01ADD"));
        } else if (b == 22) {
            Button button = findViewById(R.id.polje22);
            button.setTextColor(Color.parseColor("#E01ADD"));
        } else if (b == 32) {
            Button button = findViewById(R.id.polje32);
            button.setTextColor(Color.parseColor("#E01ADD"));
        } else if (b == 23) {
            Button button = findViewById(R.id.polje23);
            button.setTextColor(Color.parseColor("#E01ADD"));
        }

        if (c == 13) {
            Button button = findViewById(R.id.polje13);
            button.setTextColor(Color.parseColor("#E01ADD"));
        } else if (c == 31) {
            Button button = findViewById(R.id.polje31);
            button.setTextColor(Color.parseColor("#E01ADD"));
        } else if (c == 33) {
            Button button = findViewById(R.id.polje33);
            button.setTextColor(Color.parseColor("#E01ADD"));
        } else if (c == 23) {
            Button button = findViewById(R.id.polje23);
            button.setTextColor(Color.parseColor("#E01ADD"));
        } else if (c == 32) {
            Button button = findViewById(R.id.polje32);
            button.setTextColor(Color.parseColor("#E01ADD"));
        }
    }

    private boolean boardFull() {
        if (this.stSimbolov == 9) {
            this.konecIgre = true;
            return true;
        }
        return false;
    }

    private boolean allowedMove(int x, int y) {
        return mreza[x - 1][y - 1] == 0;
    }

    public void placeSymbol(View v) {
        if (this.konecIgre) {
            return;
        }

        Button button = findViewById(v.getId());

        if (v.getId() == R.id.polje11) {
            if (allowedMove(1,1)) {
                if (this.poteza == 1) {
                    this.mreza[0][0] = 1;
                    button.setText("X");
                    this.poteza = 2;
                } else {
                    this.mreza[0][0] = 2;
                    button.setText("O");
                    this.poteza = 1;
                }
                this.stSimbolov++;
            }

            if (win()) {
                // zmaga igralca
                if (this.poteza == 1) {
                    resetBoard(2);
                } else {
                    resetBoard(1);
                }
            } else if (boardFull()) {
                // remi
                resetBoard(0);
            }
        } else if (v.getId() == R.id.polje12) {
            if (allowedMove(1,2)) {
                if (this.poteza == 1) {
                    this.mreza[0][1] = 1;
                    button.setText("X");
                    this.poteza = 2;
                } else {
                    this.mreza[0][1] = 2;
                    button.setText("O");
                    this.poteza = 1;
                }
                this.stSimbolov++;
            }

            if (win()) {
                // zmaga igralca
                if (this.poteza == 1) {
                    resetBoard(2);
                } else {
                    resetBoard(1);
                }
            } else if (boardFull()) {
                // remi
                resetBoard(0);
            }
        } else if (v.getId() == R.id.polje13) {
            if (allowedMove(1,3)) {
                if (this.poteza == 1) {
                    this.mreza[0][2] = 1;
                    button.setText("X");
                    this.poteza = 2;
                } else {
                    this.mreza[0][2] = 2;
                    button.setText("O");
                    this.poteza = 1;
                }
                this.stSimbolov++;
            }

            if (win()) {
                // zmaga igralca
                if (this.poteza == 1) {
                    resetBoard(2);
                } else {
                    resetBoard(1);
                }
            } else if (boardFull()) {
                // remi
                resetBoard(0);
            }
        } else if (v.getId() == R.id.polje21) {
            if (allowedMove(2,1)) {
                if (this.poteza == 1) {
                    this.mreza[1][0] = 1;
                    button.setText("X");
                    this.poteza = 2;
                } else {
                    this.mreza[1][0] = 2;
                    button.setText("O");
                    this.poteza = 1;
                }
                this.stSimbolov++;
            }

            if (win()) {
                // zmaga igralca
                if (this.poteza == 1) {
                    resetBoard(2);
                } else {
                    resetBoard(1);
                }
            } else if (boardFull()) {
                // remi
                resetBoard(0);
            }
        } else if (v.getId() == R.id.polje22) {
            if (allowedMove(2,2)) {
                if (this.poteza == 1) {
                    this.mreza[1][1] = 1;
                    button.setText("X");
                    this.poteza = 2;
                } else {
                    this.mreza[1][1] = 2;
                    button.setText("O");
                    this.poteza = 1;
                }
                this.stSimbolov++;
            }

            if (win()) {
                // zmaga igralca
                if (this.poteza == 1) {
                    resetBoard(2);
                } else {
                    resetBoard(1);
                }
            } else if (boardFull()) {
                // remi
                resetBoard(0);
            }
        } else if (v.getId() == R.id.polje23) {
            if (allowedMove(2,3)) {
                if (this.poteza == 1) {
                    this.mreza[1][2] = 1;
                    button.setText("X");
                    this.poteza = 2;
                } else {
                    this.mreza[1][2] = 2;
                    button.setText("O");
                    this.poteza = 1;
                }
                this.stSimbolov++;
            }

            if (win()) {
                // zmaga igralca
                if (this.poteza == 1) {
                    resetBoard(2);
                } else {
                    resetBoard(1);
                }
            } else if (boardFull()) {
                // remi
                resetBoard(0);
            }
        } else if (v.getId() == R.id.polje31) {
            if (allowedMove(3,1)) {
                if (this.poteza == 1) {
                    this.mreza[2][0] = 1;
                    button.setText("X");
                    this.poteza = 2;
                } else {
                    this.mreza[2][0] = 2;
                    button.setText("O");
                    this.poteza = 1;
                }
                this.stSimbolov++;
            }

            if (win()) {
                // zmaga igralca
                if (this.poteza == 1) {
                    resetBoard(2);
                } else {
                    resetBoard(1);
                }
            } else if (boardFull()) {
                // remi
                resetBoard(0);
            }
        } else if (v.getId() == R.id.polje32) {
            if (allowedMove(3,2)) {
                if (this.poteza == 1) {
                    this.mreza[2][1] = 1;
                    button.setText("X");
                    this.poteza = 2;
                } else {
                    this.mreza[2][1] = 2;
                    button.setText("O");
                    this.poteza = 1;
                }
                this.stSimbolov++;
            }

            if (win()) {
                // zmaga igralca
                if (this.poteza == 1) {
                    resetBoard(2);
                } else {
                    resetBoard(1);
                }
            } else if (boardFull()) {
                // remi
                resetBoard(0);
            }
        } else if (v.getId() == R.id.polje33) {
            if (allowedMove(3,3)) {
                if (this.poteza == 1) {
                    this.mreza[2][2] = 1;
                    button.setText("X");
                    this.poteza = 2;
                } else {
                    this.mreza[2][2] = 2;
                    button.setText("O");
                    this.poteza = 1;
                }
                this.stSimbolov++;
            }

            if (win()) {
                // zmaga igralca
                if (this.poteza == 1) {
                    resetBoard(2);
                } else {
                    resetBoard(1);
                }
            } else if (boardFull()) {
                // remi
                resetBoard(0);
            }
        }
    }
}