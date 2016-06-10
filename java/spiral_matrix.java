public class spiral_matrix{

	static void spiral_print(int[][] M, int row, int col){
		int T = 0;
		int B = row-1;
		int L = 0;
		int R = col-1;
		int dir = 0;
		while(T <= B && L <= R){
			//going from left to right; print top row
			if(dir == 0){
				for(int i=L; i<=R; i++)
					System.out.print(M[T][i] + " ");
				T++;
			}
			//going from top to bottom; print rightmost column
			else if(dir == 1){
				for(int i=T; i<=B; i++)
					System.out.print(M[i][R] + " ");
				R--;
			}
			//going from right to left; print bottom row
			else if(dir == 2){
				for(int i=R; i>= L; i--)
					System.out.print(M[B][i] + " ");
				B--;
			}
			//going from bottom to top; print leftmost column
			else if(dir == 3){
				for(int i=B; i>= T; i--)
					System.out.print(M[i][L] + " ");
				L++;
			}
			dir = (dir+1)%4;
		}
	}
	public static void main(String[] args){
		int[][] M = {{1,2,3,4},
			     {5,6,7,8},
			     {9,10,11,12},
			     {13,14,15,16}
			     };

		int row = M.length;	//get number of rows
		int col = M[0].length;	//get number of columns

		spiral_print(M, row, col);
	}
}
