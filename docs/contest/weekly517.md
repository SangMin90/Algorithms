# Q1. Count Integers Appearing in a Single Block

- **문제 링크:** [LeetCode 4038. Count Integers Appearing in a Single Block](https://leetcode.com/problems/count-integers-appearing-in-a-single-block/description/)
- **문제 유형:** Array / Hash Table
- **결과 상태:** [x] 🟢 성공 | [ ] 🟡 시도했으나 시간 내 미해결 | [ ] 🔴 시간 부족으로 손도 못 댐

## 🟢 [성공 복기]

- **풀이 소요 시간**: 21분
- **핵심 아이디어:**
  - 배열 내에서 연속해서 뭉쳐있는 동일 수 값의 덩어리(Block)들을 하나의 그룹으로 인식한다.
  - 배열 전체를 1회 순회하면서 "각 정수 $x$가 블록(Block) 형태로 등장한 횟수"를 Map 또는 Array에 기록한다.
  - 최종적으로 등장한 블록 횟수가 정확히 1회인 정수의 개수만 카운트한다.
- **복잡도:**
  - 시간 복잡도: $O(N)$ (배열 1회 순회 및 빈도 수 계산)
  - 공간 복잡도: $O(N)$ (정수별 블록 등장 횟수를 저장할 Hash Map 공간)

## 🔍 시행착오 & 복기 (Good & Bad)

- **Good**:
  반복 등장 여부를 '값 단위'가 아닌 '연속된 블록(Group) 단위'로 카운트해야 한다는 핵심 아이디어를 잘 도출함.
- **Bad**:
  - 문제 조건(Contiguous / Single Block) 오해:
    - 요소가 1개인 경우도 길이가 1인 완벽한 하나의 블록(Single Block)으로 인정된다는 점을 간과함.
    - 정수 $x$로만 이루어진 배열 전체도 1개의 블록으로 간주된다는 점을 오판함.
  - 중복 차감 로직 오류:
    - 동일 정수의 블록이 3번 이상 나타날 때 횟수를 단순 차감 방식으로 처리하여 부정확한 빈도 왜곡이 발생함.
    - 개선책: 차감 방식 대신 이전 값(prev) 변수를 활용한 런렝스(Run-length) 방식으로 블록 발생 시점에만 count + 1을 명확히 기록하도록 수정함.

## 📝 시행착오 기록 (Fail History)

- [x] 시도 1: 요소가 1개인 경우 블록으로 인정하지 않아 예외 발생
- [x] 시도 2: 단 하나의 정수로만 이루어진 배열을 블록으로 처리하지 않음
- [x] 시도 3: 길이 1짜리 배열 예외 처리 로직에 오류가 지속됨
- [x] 시도 4: 블록 3회 이상 재등장 시 카운트를 단순 뺄셈 처리하여 빈도 왜곡 발생

## 💡 한 줄 총평

> 길이가 1인 연속 구간도 하나의 Block이라는 조건 정의를 처음에 명확히 정리하고 들어갔다면 시도 횟수를 크게 줄일 수 있었던 문제였음

## 코드

<details>
<summary><b>Java Solution (Click to expand)</b></summary>

```java
class Solution {

    private int[] visited = new int[101];

    public int countSpecialIntegers(int[] nums) {

        int start = 0;
        int end = 0;
        while (start <= end && end < nums.length) {
            if (nums[start] == nums[end]) {
                end++;
            } else {
                visited[nums[start]]++;

                start = end;
            }
        }

        visited[nums[start]]++;

        int count = 0;
        for (int i = 0; i < visited.length; i++) {
            if (visited[i] == 1) {
                count++;
            }
        }

        return count;
    }
}
```

</details>

# Q2. Sum of Decoded Numbers

- **문제 링크:** [LeetCode 4039. Sum of Decoded Numbers](https://leetcode.com/problems/sum-of-decoded-numbers/description/)
- **문제 유형:** Math
- **결과 상태:** [x] 🟢 성공 | [ ] 🟡 시도했으나 시간 내 미해결 | [ ] 🔴 시간 부족으로 손도 못 댐

---

## 🟢 [성공 복기]

- **풀이 소요 시간**: 1시간 8분
- **핵심 아이디어:**
  - 분할 정복을 통해 거듭제곱 구현
- **복잡도:**
  - 시간 복잡도: $O(NlogK)$ (배열 1회 순회 및 빈도 수 계산)
  - 공간 복잡도: $O(N)$ (정수별 블록 등장 횟수를 저장할 Hash Map 공간)
- **복잡도:** Time: / Space: $O(1)$

## 🔍 시행착오 & 복기 (Good & Bad)

- **Good**:
  거듭제곱 구현 시 분할 정복으로 구현하여 시간복잡도 $O(NK)$ -> $O(logK)$로 감소
- **Bad**:
  - Integer overflow 문제
    - 거듭제곱 시 복호화된 숫자에는 modulo 연산 미적용
  - 거듭제곱 구현 방법
    - base를 제곱수만큼 곱하여 시간복잡도 $O(N)$로 시간 제한 초과

## 📝 시행착오 기록 (Fail History)

- [x] **시도 1:** 거듭제곱의 base인 `x`를 modulo 연산하지 않아 overflow 발생
- [x] **시도 2:** 거듭제곱 횟수만큼 곱하여 시간 초과 발생

## 💡 한 줄 총평

> modulo 연산의 분배법칙 적용 대상과 거듭제곱의 시간복잡도를 줄일 방법을 알고 있었다면 풀이 시간을 대폭 줄일 수 있었음

## 코드

<details>
<summary><b>Java Solution (Click to expand)</b></summary>

```java
class Solution {
    public int sumDecoded(long[] nums) {

        final long MODULO = 1_000_000_007L;

        long sum = 0;
        for (long num : nums) {
            int width = (int) (num % 10);
            long d = num / 10;

            String str = String.valueOf(d);

            long x = Long.parseLong(str.substring(0, width));
            long y = Long.parseLong(str.substring(width));

            long decodedNum = 1;
            if (x == 1 || y == 0) {
                sum = (sum + decodedNum) % MODULO;
                continue;
            }

            x %= MODULO;
            while (y > 0) {

                if ((y & 1) == 1) {
                    decodedNum = (decodedNum * x) % MODULO;
                }

                x = (x * x) % MODULO;
                y /= 2;
            }

            sum = (sum + decodedNum) % MODULO;
        }

        return (int) sum;
    }
}
```

</details>

# Q3. Minimum Operations to Form Subset Sum

- **문제 링크:** [LeetCode 4040. Minimum Operations to Form Subset Sum](https://leetcode.com/problems/minimum-operations-to-form-subset-sum-i/description/)
- **문제 유형:** DP / Knapsack
- **결과 상태:** [ ] 🟢 성공 | [ ] 🟡 시도했으나 시간 내 미해결 | [x] 🔴 시간 부족으로 손도 못 댐

🔴 [시간 부족으로 손도 못 댄 경우만 작성]

- **지문을 못 읽은 원인:** 2번 문제에서 1시간 이상 막혀 시간이 부족했음
- **대회 후 지문 확인 결과:**
  - [ ] 시간만 있었으면 풀 수 있었던 아쉬운 문제
  - [x] 어차피 개념/알고리즘을 몰라 당장 못 풀었을 문제
- ## **해당 문제에서 새로 알게 된 알고리즘/테크닉:**
  - 제한된 용량(합계) 및 선택과 가치(포함 여부 / 연산 횟수), 분할 불가능성을 보고 `0/1 knapsack` 문제임을 알아차려야 함
  - 각 숫자 `num`별로 연산(순서는 곱하기 -> 나누기)을 통해 만들 수 있는 모든 `(값, 최소 연산 횟수)` 쌍을 `findPossible`로 사전 추출함.
  - 추출된 변환 옵션 중 **원소당 딱 1개 이하만 선택**해야 하므로, 이전 단계 `dp[i-1]`를 참조하는 2차원 Knapsack DP 적용.
- **타임 매니지먼트 피드백:**
  - 2번, 3번 문제 중 지문을 보고 빠르게 풀 수 있는 문제를 체크해야될 필요가 있음
  - 다행히 3번 문제는 못풀었음

* [x] **시간 부족:** Q1, Q2에 시간이 오래 걸려 문제 읽을 시간 부족

## 💡 한 줄 총평

> 0/1 Knapsack 변형인 걸 늦게 알아챘다. N 제한과 상태 변환을 먼저 체크하자

## 코드

<details>
<summary><b>Java Solution (Click to expand)</b></summary>

```java
public class Solution {

    private final int INF = 1000000000;

    public int minOperations(int[] nums, int sum) {

        int[][] dp = new  int[nums.length + 1][sum + 1];

        for (int i = 0; i <= nums.length; i++) {
            Arrays.fill(dp[i], INF);
            dp[i][0] = 0;
        }

        for (int i = 1; i <= nums.length; i++) {

            // 선택을 하지 않았을 때
            for (int j = 0; j <= sum; j++) {
                dp[i][j] = dp[i - 1][j];
            }

            // 선택했을 때
            Map<Integer, Integer> possible = findPossible(nums[i - 1], sum);

            for (Map.Entry<Integer, Integer> entry : possible.entrySet()) {
                int value = entry.getKey();
                int cost = entry.getValue();

                for (int j = value; j <= sum; j++) {
                    if (dp[i - 1][j - value] != INF) {
                        dp[i][j] = Math.min(dp[i][j], dp[i - 1][j - value] + cost);
                    }
                }
            }
        }

        return dp[nums.length][sum] == INF ? -1 : dp[nums.length][sum];
    }

    private Map<Integer, Integer> findPossible(int num, int sum) {

        final Map<Integer, Integer> possible = new HashMap<>();

        int curr = num;
        int multiplyCnt = 0;

        while (true) {

            int value = curr;
            int divideCnt = 0;
            while (value >= 1) {
                if (value <= sum) {
                    possible.put(value, Math.min(possible.getOrDefault(value, INF), divideCnt + multiplyCnt));
                }

                divideCnt++;
                value /= 2;
            }

            if (curr > sum) {
                break;
            }

            curr *= 2;
            multiplyCnt++;
        }

        return possible;
    }

}

```

</details>

# Q4. Minimum Operations to Form Subset Sum II

- **문제 링크:** [LeetCode 4041. Minimum Operations to Form Subset Sum](https://leetcode.com/problems/minimum-operations-to-form-subset-sum-ii/description/)
- **문제 유형:** DP / Knapsack
- **결과 상태:** [ ] 🟢 성공 | [ ] 🟡 시도했으나 시간 내 미해결 | [x] 🔴 시간 부족으로 손도 못 댐

🔴 [시간 부족으로 손도 못 댄 경우만 작성]

- **지문을 못 읽은 원인:** 2번 문제에서 1시간 이상 막혀 시간이 부족했음
- **대회 후 지문 확인 결과:**
  - [ ] 시간만 있었으면 풀 수 있었던 아쉬운 문제
  - [x] 어차피 개념/알고리즘을 몰라 당장 못 풀었을 문제
- ## **해당 문제에서 새로 알게 된 알고리즘/테크닉:**
  - 제한된 용량(합계) 및 선택과 가치(포함 여부 / 연산 횟수), 분할 불가능성을 보고 `0/1 knapsack` 문제임을 알아차려야 함
  - 각 숫자 `num`별로 연산(곱하기/나누기)을 통해 만들 수 있는 모든 `(값, 최소 연산 횟수)` 쌍을 `findPossible`로 사전 추출함
  - 추출된 변환 옵션 중 **원소당 딱 1개 이하만 선택**해야 하므로, 이전 단계 `dp[i-1]`를 참조하는 2차원 Knapsack DP 적용
- **타임 매니지먼트 피드백:**
  - 3번과 4번의 문제 유사성을 체크할 필요가 있을 듯

* [x] **시간 부족:** Q1, Q2에 시간이 오래 걸려 문제 읽을 시간 부족

## 💡 한 줄 총평

> 0/1 Knapsack 변형인 걸 늦게 알아챘다. N 제한과 상태 변환을 먼저 체크하자

## 코드

<details>
<summary><b>Java Solution (Click to expand)</b></summary>

```java
public class Solution {

    private final int INF = 1000000000;

    public int minOperations(int[] nums, int sum) {

        int n = nums.length;
        int[][] dp = new int[n + 1][sum + 1];

        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], INF);
            dp[i][0] = 0;
        }


        for (int i = 1; i <= n; i++) {

            // 사용 X
            for (int j = 1; j <= sum; j++) {
                dp[i][j] = dp[i - 1][j];
            }

            // 사용 O
            Map<Integer, Integer> possible = findPossible(nums[i - 1], sum);
            for (Map.Entry<Integer, Integer> entry : possible.entrySet()) {
                int value = entry.getKey();
                int cost = entry.getValue();

                for (int j = value; j <= sum; j++) {
                    if (dp[i - 1][j - value] != INF) {
                        dp[i][j] = Math.min(dp[i][j], dp[i - 1][j - value] + cost);
                    }
                }
            }
        }

        return dp[n][sum] == INF ? -1 : dp[n][sum];
    }

    private Map<Integer, Integer> findPossible(int num, int sum) {

        Map<Integer, Integer> possible = new HashMap<>();

        int divideCnt = 0;
        int value = num;
        while (value > 1) {
            if (value <= sum) {
                possible.put(value, Math.min(possible.getOrDefault(value, INF), divideCnt));

                if (value * 2 <= sum) {
                    int multiplyCnt = 1;
                    int multiply = value * 2;
                    while (multiply <= sum) {
                        possible.put(multiply, Math.min(possible.getOrDefault(multiply, INF), divideCnt + multiplyCnt));
                        multiply *= 2;
                        multiplyCnt++;
                    }
                }
            }

            value /= 2;
            divideCnt++;
        }

        // 1부터 곱하는 경우
        int multiplyCnt = 0;
        while (value <= sum) {
            possible.put(value, Math.min(possible.getOrDefault(value, INF), divideCnt + multiplyCnt));
            value *= 2;
            multiplyCnt++;
        }

        return possible;
    }
}

```

</details>
