import com.study.common.util.XFileUtils;

public class P81 {

	public static void main(String[] args) throws Exception {
		int[][] matrix = XFileUtils
				.readIntMatrixFromFile("data/p081_matrix.txt");
		int rad = matrix.length;
		int[][] minSum = new int[rad][rad];
		// 初始化边界
		minSum[0][0] = matrix[0][0];
		for (int i = 1; i < rad; i++) {
			minSum[0][i] = minSum[0][i - 1] + matrix[0][i];
			minSum[i][0] = minSum[i - 1][0] + matrix[i][0];
		}

		for (int i = 1; i < rad; i++) {
			for (int j = 1; j < rad; j++) {
				int min = minSum[i - 1][j] < minSum[i][j - 1] ? minSum[i - 1][j]
						: minSum[i][j - 1];
				minSum[i][j] = min + matrix[i][j];
			}
		}

		System.out.println(minSum[rad - 1][rad - 1]);
	}

}
