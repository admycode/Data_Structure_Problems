public class rotateMatrix_90{

	static void rotate_clockwise(int[][] M, int n){
		
		for(int x=0; x < n/2; x++){
			for(int y=x; y<n-1-x; y++){
				
				int top = M[x][y];
				M[x][y] = M[n-1-y][x];
				M[n-1-y][x] = M[n-1-x][n-1-y];
				M[n-1-x][n-1-y] = M[y][n-1-x];
				M[y][n-1-x] = top;
			}
		}
	}
	static void rotate_anticlockwise(int[][] M, int n){
		
		for(int x=0; x < n/2; x++){
			for(int y=x; y<n-1-x; y++){
				
				int top = M[x][y];
				M[x][y] = M[y][n-1-x];
				M[y][n-1-x] = M[n-1-x][n-1-y];
				M[n-1-x][n-1-y] = M[n-1-y][x];
				M[n-1-y][x] = top;
			}
		}
	}
	
	static void print(int[][] M, int n){
		for(int i=0; i<n; i++){
			for(int j=0; j<n; j++){
				System.out.print(M[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args){

		int[][] M = {{1,2,3,4}, {5,6,7,8}, {9,10,11,12}, {13,14,15,16}};

		int n = M.length;

		System.out.println("Clockwise 90 degree rotate");

		rotate_clockwise(M,n);

		print(M,n);

		System.out.println("Anti-Clockwise 90 degree rotate");

		rotate_anticlockwise(M,n);
		print(M,n);
	}
}
