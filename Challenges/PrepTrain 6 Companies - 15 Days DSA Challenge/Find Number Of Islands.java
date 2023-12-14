import java.util.ArrayList;

public class Solution {

    private static int dx[] = { 0, 1, 1, 1, 0, -1, -1, -1 };
    private static int dy[] = { -1, -1, 0, 1, 1, 1, 0, -1 };

    private static ArrayList<ArrayList<Boolean>> vis = new ArrayList<>();

    private static void getTotalIslandsHelper(int[][] mat, int n, int m, int x, int y) {

        if (!(x >= 0 && x < n && y >= 0 && y < m && mat[x][y] == 1 && !vis.get(x).get(y))) {
            return;
        }

        vis.get(x).set(y, true);

        for (int i = 0; i < 8; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];

            getTotalIslandsHelper(mat, n, m, nextX, nextY);
        }
    }

    public static int getTotalIslands(int[][] mat) {
        int n = mat.length;
        if (n == 0) {
            return 0;
        }
        int m = mat[0].length;
        for (int i = 0; i < n; i++) {
            vis.add(new ArrayList<>());
            ArrayList<Boolean> list = vis.get(i);
            for (int j = 0; j < m; j++) {
                list.add(false);
            }
        }

        int islands = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 1 && !vis.get(i).get(j)) {
                    islands++;
                    getTotalIslandsHelper(mat, n, m, i, j);
                }
            }
        }

        return islands;
    }

}