package org.example.신고_결과_받기;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {

    @DisplayName("정지 조건 횟수를 넘지 못하면 알림을 받지 못한다.")
    @Test
    public void blockThreshold1() {
        String[] userIds = {"ryan", "con"};
        String[] reports = {"ryan con"};
        int blockthreshold = 2;

        int[] result = new Solution().solution(userIds, reports, blockthreshold);

        assertThat(result).isEqualTo(new int[]{0, 0});
    }

    @DisplayName("정지 조건 횟수를 넘은 유저에 대해서 메일을 받는다.")
    @Test
    public void blockThreshold2() {
        String[] userIds = {"ryan", "con"};
        String[] reports = {"ryan con"};
        int blockthreshold = 1;

        int[] result = new Solution().solution(userIds, reports, blockthreshold);

        assertThat(result).isEqualTo(new int[]{1, 0});
    }

    @DisplayName("동일 유저에 대한 신고 횟수는 1회로 처리된다.")
    @Test
    public void notAllowDuplicateReport() {
        String[] userIds = {"ryan", "con"};
        String[] reports = {
                "ryan con",
                "ryan con",
                "ryan con",
                "ryan con"
        };
        int blockthreshold = 1;

        int[] result = new Solution().solution(userIds, reports, blockthreshold);

        assertThat(result).isEqualTo(new int[]{1, 0});
    }

    @DisplayName("신고 했던 유저에가 정지당하면 알림 받는 조건이 된다.")
    @Test
    public void alarmCondition() {
        String[] userIds = {"muzi", "frodo", "apeach", "neo"};
        String[] reports = {
                "muzi frodo",
                "apeach frodo",
                "frodo neo",
                "muzi neo",
                "apeach muzi"
        };
        int blockthreshold = 2;

        int[] result = new Solution().solution(userIds, reports, blockthreshold);

        assertThat(result).isEqualTo(new int[]{2, 1, 1, 0});
    }
}
