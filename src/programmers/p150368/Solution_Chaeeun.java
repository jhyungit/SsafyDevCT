package programmers.p150368;

import java.util.*;

class Solution {

    final int[] rates = {10, 20, 30, 40};

    int[][] users;
    int[] emoticons;
    int[] selected;

    int maxPlus = 0;
    int maxSales = 0;
    int eCount, uCount;

    public int[] solution(int[][] users, int[] emoticons) {
        this.users = users;
        this.emoticons = emoticons;
        this.eCount = emoticons.length;
        this.selected = new int[eCount];

        dfs(0);

        return new int[]{maxPlus, maxSales};
    }

    void dfs(int depth) {
        if (depth == eCount) {
            evaluate();
            return;
        }

        for (int rate : rates) {
            selected[depth] = rate;
            dfs(depth + 1);
        }
    }

    void evaluate() {
        Map<Integer, Integer> sumMap = new HashMap<>();

        for (int rate : rates) {
            sumMap.put(rate, 0);
        }

        for (int i = 0; i < eCount; i++) {
            int discount = selected[i];
            int price = emoticons[i] * (100 - discount) / 100;

            for (int rate : rates) {
                if (discount >= rate) {
                    sumMap.put(rate, sumMap.get(rate) + price);
                }
            }
        }

        int plus = 0;
        int sales = 0;

        for (int[] user : users) {
            int userRate = user[0];
            int userLimit = user[1];

            int targetRate = getTargetRate(userRate);
            int cost = sumMap.get(targetRate);

            if (cost >= userLimit) {
                plus++;
            } 
            else {
                sales += cost;
            }
        }

        if (plus > maxPlus) {
            maxPlus = plus;
            maxSales = sales;
        } 
        else if (plus == maxPlus && sales > maxSales) {
            maxSales = sales;
        }
    }

    int getTargetRate(int userRate) {
        if (userRate <= 10) return 10;
        if (userRate <= 20) return 20;
        if (userRate <= 30) return 30;
        return 40;
    }

}
