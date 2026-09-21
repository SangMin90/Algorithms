# Q1. Number of Intersecting Interval Pairs I

- **문제 링크:** [LeetCode 4056. Number of Intersecting Interval Pairs I](https://leetcode.com/problems/number-of-intersecting-interval-pairs-i/description/)
- **문제 유형:** Binary Search / Sweeping Line
- **결과 상태:** [x] 🟢 성공 | [ ] 🟡 시도했으나 시간 내 미해결 | [ ] 🔴 시간 부족으로 손도 못 댐

## 🟢 [성공 복기]

- **풀이 소요 시간**: 22분
- **핵심 아이디어:**
  - 주어진 배열을 선분의 $start_{i}$ 값을 기준으로 오름차순 정렬
  - 배열을 이중 순회하여 두 선분 $L_{1}$과 $L_{2}$ 간 교차 여부 판단 ($start_{1} <= start_{2} <= end_{1}$)
- **복잡도:**
  - 시간 복잡도: $O(N^2)$ (이중 순회)
  - 공간 복잡도: $O(1)$

## 🔍 시행착오 & 복기 (Good & Bad)

- **Good**:
  - 문제 조건을 보고 시간 초과가 나지 않을 것으로 판단하여 시간 복잡도 $O(N^2)$으로 풀음
- **Bad**:
  - 교차 여부 판단 알고리즘 고민 시 시간 복잡도 $O(N^2)$이 아닌 방법을 떠올리지 못함

## 📝 시행착오 기록 (Fail History)

- 해당 없음

## 🤔 추가로 생각해볼만한 풀이

- Sort + Binary Search
  - 가정: $end_{2} < start_{1}$ 이면 두 선분을 교차하지 않는다.
  - 핵심 아이디어: 전체 선분 쌍에서 교차하지 않는 선분 쌍의 수를 제외한다.
  - 풀이 방법
    - ① 배열을 선분의 $start_{i}$ 값을 기준으로 오름차순
    - ② 이분 탐색을 통해 선분의 $end_{i}$ 값이 비교 대상 선분의 $start_{j}$ 값보다 작아지는 인덱스 $j$ 탐색
    - ③ j 이후의 선분은 교차하지 않으므로 $N - j$를 통해 교차하지 않는 선분 쌍의 수를 구함
    - ④ 배열을 순회하며 ②, ③ 반복
- Sweeping Line + Two Pointer
  - 가정: $end_{2} < start_{1}$ 이면 두 선분을 교차하지 않는다.
  - 핵심 아이디어: 특정 $end_{j}$ 포인트에서 아직 끝나지 않은 두 선분이 있다면 두 선분은 교차한다.
  - 풀이 방법
    - ① 선분의 시작점 배열과 끝점 배열을 초기화하여 오름차순으로 정렬
    - ② 시작점($start_{i}$)와 끝점($end_{j}$)의 값을 비교하여 $end_{j} < start_{i}$로 선분이 끝난 경우, 끝난 선분의 수 증가 (`j++`)
    - ③ `i - j`를 통해 전체 선분에서 끝난 선분의 수를 뺌으로써 교차하는 선분의 쌍 수를 구함
    - ④ 시작점 배열을 순회하며 ②, ③ 반복

## 💡 한 줄 총평

> 문제에 추가 공간 사용 제한 조건이 없었으므로 추가 공간을 사용했다면 더 빠르게 해결할 수 있었음

## 코드

<details>
<summary><b>Java Solution (Click to expand)</b></summary>

```java
public class Solution {

    public int countIntersectingIntervals(int[][] intervals) {

        Arrays.sort(intervals, (o1, o2) -> {
            if (o1[0] == o2[0]) {
                return Integer.compare(o1[1], o2[1]);
            }

            return Integer.compare(o1[0], o2[0]);
        });

        int count = 0;

        for (int i = 0; i < intervals.length; i++) {
            for (int j = i + 1; j < intervals.length; j++) {
                int[] pointI = intervals[i];
                int[] pointJ =  intervals[j];

                if (pointI[0] <= pointJ[0] && pointJ[0] <= pointI[1]) {
                    count++;
                }
            }
        }

        return count;
    }
}
```

## </details>

<br>

# Q2. Number of Intersecting Interval Pairs II

- **문제 링크:** [LeetCode 4057. Number of Intersecting Interval Pairs II
  ](https://leetcode.com/problems/minimum-operations-to-make-every-element-palindromic/)
- **문제 유형:** Binary Search / Sweeping Line
- **결과 상태:** [ ] 🟢 성공 | [x] 🟡 시도했으나 시간 내 미해결 | [ ] 🔴 시간 부족으로 손도 못 댐

---

## 🟡 [시간 내 미해결 복기]

- **놓친 핵심 아이디어:**
  - 전체 선분 쌍의 수에서 교차하지 않는 선분 쌍의 수를 빼는 여집합
  - Binary Search(시간 복잡도, $O(logN)$)를 통해 $end_{j} < start_{i}$인 non-intersect 선분 쌍의 수를 구함

## 🔍 시행착오 & 복기 (Good & Bad)

- **Good**:
  - 없음
- **Bad**:
  - Two Pointer를 통해 `Map<Pair, Integer>`으로 선분이 교차하는 구간을 key로, 겹치는 선분의 수를 value로 관리하려고 하였으나, 중간에 교차 구간을 쪼개는 과정이 너무 복잡하였음

## **해당 문제에서 새로 알게 된 알고리즘/테크닉:**

- Sweeping Line 알고리즘
  - 정의: 평면이나 직선 상의 데이터를 한쪽 방향으로 쓸고 지나가듯(scanning) 정렬된 순서대로 처리하여 문제를 효율적으로 해결하는 기법
  - 적용 방법:
    - 각 도형이나 구간의 시작점과 끝점을 이벤트로 둠
    - 이벤트를 좌표 값 또는 시간 순서대로 오름차순 정렬
    - 이벤트를 순회하며 현재 상태(활성 집합, 겹침 횟수 등)를 갱신하며 정답 도출

    ```java
    int intersectCount = 0;
    int[] start = new int[n];
    int[] end = new int[n];

    for (int i = 0; i < n; i++) {
        start[i] = intervals[i][0];
        end[i] = intervals[i][1];
    }

    int i = 0;
    int j = 0;
    while (i < n) {
        while (j < n && end[j] < start[i]) {
            j++;
        }

        // i: 현재까지의 interval 개수, j: 끝나버린 interval 개수
        intersectCount += i - j;
        i++;
    }

    return intersectCount;

    ```

## 📝 시행착오 기록 (Fail History)

- [x] **시도 1:** Two Pointer로 정렬된 선분을 순회하며 교차되는 구간을 관리하였으나, 교차 구간에 겹쳐진 선분의 수를 제대로 설정하지 못함

## 💡 한 줄 총평

> 문제가 복잡할 땐 반대 케이스를 고려하거나 선분의 교차를 구하는 문제의 경우 Sweeping Line 알고리즘을 고려한다.

## 다른 사람이 풀은 코드

<details>
<summary><b>Java Solution (Click to expand)</b></summary>

```java
class Solution {

    // Sort + Binary Search
    public long countIntersectingIntervals(int[][] intervals) {
        int n = intervals.length;
        long[] sorted = new long[n];

        for (int i = 0; i < n; i++) {
            sorted[i] = (((long) intervals[i][0]) << 32) | (intervals[i][1] & 0xFFFFFFFFL);
        }

        Arrays.sort(sorted);

        long nonIntersectCount = 0;
        for (int i = 0; i < n; i++) {
            long interval = sorted[i];
            long end = interval & 0xFFFFFFFFL;

            int low = i + 1;
            int high = n - 1;
            while (low <= high) {
                int mid = low + (high - low) / 2;

                long start = sorted[mid] >>> 32;
                if (start <= end) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }

            nonIntersectCount += n - low;

        }

        long totalCnt = (((long) n) * (n - 1) / 2);
        return totalCnt - nonIntersectCount;
    }

    // Sweeping Line
    public long countIntersectingIntervals2(int[][] intervals) {

        long ans = 0;

        int n = intervals.length;
        int[] start = new int[n];
        int[] end = new int[n];

        for (int i = 0; i < n; i++) {
            start[i] = intervals[i][0];
            end[i] = intervals[i][1];
        }

        int i = 0;
        int j = 0;
        while (i < n) {
            while (j < n && end[j] < start[i]) {
                j++;
            }

            // i: 현재까지의 interval 개수, j: 끝나버린 interval 개수
            ans += i - j;
            i++;
        }

        return ans;
    }
}
```

</details>
<br>

# Q3. Maximum Pulse Value After One Subarray Rotation

- **문제 링크:** [LeetCode 4058. Maximum Pulse Value After One Subarray Rotation](https://leetcode.com/problems/maximum-pulse-value-after-one-subarray-rotation/description/)
- **문제 유형:** Kadane
- **결과 상태:** [ ] 🟢 성공 | [ ] 🟡 시도했으나 시간 내 미해결 | [x] 🔴 시간 부족으로 손도 못 댐

## 🔴 읽지도 못한 문제 복기

- **지문을 못 읽은 원인:** 1번과 2번 문제 풀이에 시간을 많이 잡아 먹음
- **대회 후 지문 확인 결과:**
  - [ ] 시간만 있었으면 풀 수 있었던 아쉬운 문제
  - [x] 어차피 개념/알고리즘을 몰라 당장 못 풀었을 문제

### **해당 문제에서 새로 알게 된 알고리즘/테크닉:**

- **테크닉**
  - 배열 회전(Subarray Rotation) 문제에서 직접 시뮬레이션 대신 회전 전후의 변화량(Delta/Gain)을 수식화하여 Kadane's Algorithm으로 환원(Reduction)하는 테크닉

## 💡 한 줄 총평

> 배열 회전과 같은 구간 변경 문제에서 변경 발생 시 변화량(delta)을 분석하여 Kadane 알고리즘으로 변환하는 패턴 습득 필요

## 코드

<details>
<summary><b>Java Solution (Click to expand)</b></summary>

```java
public class Solution {

    public long maxValue(int[] nums) {

        int n = nums.length;
        long[] P = new long[n + 1];

        for (int i = 0; i < n; i++) {
            if ((i & 1) == 0) {
                P[i + 1] = P[i] + nums[i];
            } else {
                P[i + 1] = P[i] - nums[i];
            }
        }

        long kadane = 0;
        for (int i = 0; i <= 1; i++) {
            int sign = 1 - (i << 1);
            long curr = 0;
            for (int j = i; j < n - 1; j += 2) {
                long diff = ((long) nums[j + 1] - nums[j]) * sign;
                curr = Math.max(diff, curr + diff);
                kadane = Math.max(kadane, 2 * curr);
            }
        }

        return Math.max(kadane + P[n], P[n]);
    }
}

```

</details>
<br>

# Q4. Lexicographically Largest Power Array

- **문제 링크:** [LeetCode 4059. Lexicographically Largest Power Array](https://leetcode.com/problems/lexicographically-largest-power-array/)
- **문제 유형:** Greedy / Bit Masking / Divide & Conquer / Group Partitioning
- **결과 상태:** [ ] 🟢 성공 | [ ] 🟡 시도했으나 시간 내 미해결 | [x] 🔴 시간 부족으로 손도 못 댐

## 🔴 읽지도 못한 문제 복기

- **지문을 못 읽은 원인:** 1번 문제 풀이에 시간을 많이 잡아 먹고, 2번 문제 풀이 방향을 잘못 잡아 손도 댈 수 없었음
- **대회 후 지문 확인 결과:**
  - [ ] 시간만 있었으면 풀 수 있었던 아쉬운 문제
  - [x] 어차피 개념/알고리즘을 몰라 당장 못 풀었을 문제

### **해당 문제에서 새로 알게 된 알고리즘/테크닉:**

- **테크닉**
  비트 단위(MSB $\rightarrow$ LSB) 그리디 문제에서, 상위 비트 결과가 같은 원소들끼리 그룹으로 묶어 쪼개나가는 Group Partitioning / Divide & Conquer 방식을 사용해야 한다.

## 💡 한 줄 총평

> Bitwise Trie나 Bitwise Grouping 형태의 그리디 문제를 만났을 때, Bit Masking을 통한 Group Partitioning / Divide & Conquer 방식을 고려할 수 있어야 함

## 다른 사람이 풀은 코드

<details>
<summary><b>Java Solution (Click to expand)</b></summary>

```java
public class Solution {

    public int[] largestPower(int[] nums) {

        final int totalBits = 15;

        List<Long> initGroup = new ArrayList<>();
        for (int num : nums) {
            initGroup.add(num & 0xFFFFFFFFL);
        }

        Node groups = new Node(initGroup);

        int[] bits = new int[totalBits];
        int bit = 0;
        while (bit < totalBits) {

            Node curr = groups;
            while (curr != null) {

                List<Long> currElements = new ArrayList<>();
                List<Long> nextElements = new ArrayList<>();
                for (int index = 0; index < curr.elements.size(); index++) {
                    long element = curr.elements.get(index);
                    if ((element & (1L << (totalBits - bit - 1))) == 0) {
                        nextElements.add(element);
                    } else {
                        currElements.add(element);
                    }
                }

                if (currElements.isEmpty()) {
                    break;
                }

                if (nextElements.isEmpty()) {
                    bits[bit] += currElements.size();
                    curr = curr.next;
                    continue;
                }

                Node nextGroup = new Node(nextElements);
                curr.elements = currElements;
                nextGroup.next = curr.next;
                curr.next = nextGroup;

                bits[bit] += curr.elements.size();
                break;
            }

            bit++;
        }

        return bits;
    }

    static class Node {
        List<Long> elements;
        Node next;

        Node(List<Long> elements) {
            this.elements = elements;
        }
    }

    public int[] largestPower2(int[] nums) {
        List<List<Long>> groups = new ArrayList<>();

        List<Long> initGroup = new ArrayList<>();
        for (int num : nums) {
            initGroup.add(num & 0xFFFFFFFFL);
        }

        groups.add(initGroup);

        int n = 15;
        int[] power = new int[n];
        for (int bit = 0; bit < n; bit++) {

            for (int i = 0; i < groups.size(); i++) {

                List<Long> zero = new ArrayList<>();
                List<Long> one = new ArrayList<>();

                List<Long> currGroup = groups.get(i);
                for (Long element : currGroup) {
                    if ((element & (1L << (n - bit - 1))) > 0) {
                        one.add(element);
                    } else {
                        zero.add(element);
                    }
                }

                if (one.isEmpty()) {
                    break;
                }

                if (zero.isEmpty()) {
                    power[bit] += one.size();
                    continue;
                }

                groups.set(i, one);
                groups.add(i + 1, zero);

                power[bit] += one.size();
                break;
            }
        }

        return power;
    }
}

```

</details>
