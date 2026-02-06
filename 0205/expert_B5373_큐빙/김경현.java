package algorithm;
import java.util.*;
import java.io.*;

public class boj_5373 {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));;
    public static StringTokenizer st;
    public static StringBuilder sb = new StringBuilder();

    public static int nextInt() throws IOException {
        while(st == null || !st.hasMoreElements()){
            st = new StringTokenizer(br.readLine());
        }
        return Integer.parseInt(st.nextToken());
    }

    public static String next() throws IOException {
        while (st == null || !st.hasMoreElements()) {
            st = new StringTokenizer(br.readLine());
        }
        return st.nextToken();
    }

    static char[][] U = new char[3][3];
    static char[][] D = new char[3][3];
    static char[][] F = new char[3][3];
    static char[][] B = new char[3][3];
    static char[][] L = new char[3][3];
    static char[][] R = new char[3][3];

    public static void initCube(){
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                U[i][j] = 'w';
                D[i][j] = 'y';
                F[i][j] = 'r';
                B[i][j] = 'o';
                L[i][j] = 'g';
                R[i][j] = 'b';
            }
        }
    }


    public static char[][] turn_target(char[][] board) {
        char[][] tmp = new char[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                tmp[j][2 - i] = board[i][j];
            }
        }
        return tmp;
    }
    // U: 위(w), D: 아래(y), F: 앞(r), B: 뒤(o), L: 왼(g), R: 오(b)
    // + 시계, - 반시계

    public static void turn_right(char cond) {
        char[] tmp = new char[3];

        if (cond == 'U') {
            for(int i=0; i<3; i++) tmp[i] = F[0][i];
            for(int i=0; i<3; i++) F[0][i] = R[0][i];
            for(int i=0; i<3; i++) R[0][i] = B[0][i];
            for(int i=0; i<3; i++) B[0][i] = L[0][i];
            for(int i=0; i<3; i++) L[0][i] = tmp[i];
            
            U = turn_target(U);
        } else if (cond == 'D') {
            for(int i=0; i<3; i++) tmp[i] = F[2][i];
            for(int i=0; i<3; i++) F[2][i] = L[2][i];
            for(int i=0; i<3; i++) L[2][i] = B[2][i];
            for(int i=0; i<3; i++) B[2][i] = R[2][i];
            for(int i=0; i<3; i++) R[2][i] = tmp[i];
            
            D = turn_target(D);
        } else if (cond == 'F') {
            for(int i=0; i<3; i++) tmp[i] = U[2][i];
            for(int i=0; i<3; i++) U[2][i] = L[2-i][2];
            for(int i=0; i<3; i++) L[i][2] = D[0][i];
            for(int i=0; i<3; i++) D[0][i] = R[2-i][0];
            for(int i=0; i<3; i++) R[i][0] = tmp[i];
           
            F = turn_target(F);
        } else if (cond == 'B') {
            for(int i=0; i<3; i++) tmp[i] = U[0][i];
            for(int i=0; i<3; i++) U[0][i] = R[i][2];
            for(int i=0; i<3; i++) R[i][2] = D[2][2-i];
            for(int i=0; i<3; i++) D[2][i] = L[i][0];
            for(int i=0; i<3; i++) L[i][0] = tmp[2-i];
            
            B = turn_target(B);
        } else if (cond == 'L') {
            for(int i=0; i<3; i++) tmp[i] = U[i][0];
            for(int i=0; i<3; i++) U[i][0] = B[2-i][2];
            for(int i=0; i<3; i++) B[i][2] = D[2-i][0];
            for(int i=0; i<3; i++) D[i][0] = F[i][0];
            for(int i=0; i<3; i++) F[i][0] = tmp[i];
            
            L = turn_target(L);
        } else if (cond == 'R') {
            for(int i=0; i<3; i++) tmp[i] = U[i][2];
            for(int i=0; i<3; i++) U[i][2] = F[i][2];
            for(int i=0; i<3; i++) F[i][2] = D[i][2];
            for(int i=0; i<3; i++) D[i][2] = B[2-i][0];
            for(int i=0; i<3; i++) B[i][0] = tmp[2-i];
            
            R = turn_target(R);
        }
    }

    public static void solve() throws IOException {
        initCube();
        int n = nextInt();

        for(int i = 0; i < n; i++){
            String op = next();
            char cond = op.charAt(0);
            char dir = op.charAt(1);

            if(dir == '+'){
                turn_right(cond);
            }
            else{
                for(int j = 0; j < 3; j++){
                    turn_right(cond);
                }
            }
        }

        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                sb.append(U[i][j]);
            }
            sb.append('\n');
        }
    }


    public static void main(String[] args) throws IOException{
        st = new StringTokenizer(br.readLine());
        int T = nextInt();

        while(T-- > 0){
            solve();
        }
        System.out.print(sb);
    }
}
