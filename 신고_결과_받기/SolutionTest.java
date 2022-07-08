package 신고_결과_받기;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class SolutionTest {

    @DisplayName("각 유저는 한 번에 한 명의 유저를 신고할 수 있다.")
    @Test
    public void notAllowDuplicateReport() {
        String[] userIds = {"ryan con"};
        String[] reports = {"ryan con", "ryan con", "ryan con", "ryan con"};

        int[] result = new Solution().solution(ㅕㄴㄷㄱ);

        assertThat(result);
    }

    @DisplayName("동일 유저에 대한 신고 횟수는 1회로 처리된다.")
    @Test
    public void 테스트2() {

    }

    @DisplayName("K번 신고된 유저는 이용이 정지되고, 해당 유저를 신고한 유저에게 메일로 알람을 발송한다.")
    @Test
    public void 테스트3() {

    }
}
