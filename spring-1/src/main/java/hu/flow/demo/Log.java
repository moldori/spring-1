package hu.flow.demo;

public class Log {

    private HullData hullData;
    private HullRequestDTO hullDataDTO;
    private long timeStamp;

    public Log() {
    }

    public Log(HullData hullData, HullRequestDTO hullDataDTO, long timeStamp) {
        this.hullData = hullData;
        this.hullDataDTO = hullDataDTO;
        this.timeStamp = timeStamp;
    }

    public HullData getHullData() {
        return hullData;
    }

    public void setHullData(HullData hullData) {
        this.hullData = hullData;
    }

    public HullRequestDTO getHullDataDTO() {
        return hullDataDTO;
    }

    public void setHullDataDTO(HullRequestDTO hullDataDTO) {
        this.hullDataDTO = hullDataDTO;
    }

    public long getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(long timeStamp) {
        this.timeStamp = timeStamp;
    }
}
