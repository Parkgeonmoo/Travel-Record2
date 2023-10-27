package toy.five.triprecord.domain.jouney.dto.journey_update.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import toy.five.triprecord.domain.jouney.entity.JourneyType;
import toy.five.triprecord.domain.jouney.entity.LodgmentJourney;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
//@NoArgsConstructor
@Builder
public class LodgmentJourneyUpdateResponse {

    private Long tripId;
    private String name;
    private String dormitoryName;
    private JourneyType type;
    private LocalDateTime startTime;
    private LocalDateTime endTime;

    public static LodgmentJourneyUpdateResponse fromEntity(LodgmentJourney entity) {
        return LodgmentJourneyUpdateResponse.builder()
                .tripId(entity.getTrip().getId())
                .name(entity.getName())
                .dormitoryName(entity.getDormitoryName())
                .type(entity.getType())
                .startTime(entity.getStartTime())
                .endTime(entity.getEndTime())
                .build();
    }

}
