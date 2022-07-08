package org.example.신고_결과_받기;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/92334
 */
public class Solution {

    final String RECORD_DELIMTER = " ";

    /**
     * @param userIds        이용자 ID 목록
     * @param reports        [이용자 신고당한_이용자_ID] 형태의 목록
     * @param blockthreshold 정지 기준이 되는 신고 횟수
     * @return id 순서대로 각 유저가 받은 결과 메일 수 배열
     */
    public int[] solution(String[] userIds, String[] reports, int blockthreshold) {
        // 이용자 별 신고 목록 체크
        Map<String, List<String>> userIdToUserReportIds = new HashMap<>();

        // 이용자 별 신고 목록 체크
        for (int i = 0; i < reports.length; i++) {
            String[] splitedReport = reports[i].split(RECORD_DELIMTER);
            String userId = splitedReport[0];
            String reportUserId = splitedReport[1];
            List<String> reportUserIds = userIdToUserReportIds.getOrDefault(userId, new ArrayList<>());
            if (!reportUserIds.contains(reportUserId)) {
                reportUserIds.add(reportUserId);
            }
            userIdToUserReportIds.put(userId, reportUserIds);
        }

        // 신고 횟수 체크
        Map<String, Integer> reportUserIdToReportCount = new HashMap<>();
        userIdToUserReportIds.forEach((userId, reportUserIds) -> reportUserIds
                .forEach(reportUserId -> {
                    Integer reportCount = reportUserIdToReportCount.getOrDefault(reportUserId, 0);
                    reportCount += 1;
                    reportUserIdToReportCount.put(reportUserId, reportCount);
                }));

        // 입력 받은 userIds 순서대로 결과 생성
        int[] answer = new int[userIds.length];
        for (int i = 0; i < userIds.length; i++) {
            answer[i] = 0;
            String userId = userIds[i];
            List<String> userReportIds = userIdToUserReportIds.get(userId);
            if (userReportIds != null) {
                for (String userReportId : userReportIds) {
                    Integer reportCount = reportUserIdToReportCount.get(userReportId);
                    if (reportCount >= blockthreshold) {
                        answer[i] += 1;
                    }
                }
            }
        }

        return answer;
    }
}
