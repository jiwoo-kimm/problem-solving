// 2018 카카오 블라인드 채용
// 방금그곡
// 2021.03.09

import java.util.*;

class Solution {   
    
    private List<Music> musics = new ArrayList<>();

    public String solution(String m, String[] musicInfos) {
        parseMusicInfos(musicInfos);
        Music result = findTargetMusic(m);
        if (result == null) return "(None)";
        return result.title;
    }

    private void parseMusicInfos(String[] musicInfos) {
        for (String musicInfo : musicInfos) {
            String[] chunks = musicInfo.split(",");
            musics.add(new Music(chunks[0], chunks[1], chunks[2], chunks[3]));
        }
    }

    private Music findTargetMusic(String targetNotes) {
        Music result = null;
        for (Music music : musics)
            if (isTargetAndMusicMatch(targetNotes, music))
                if (result == null || isUpdatable(result, music))
                    result = music;
        return result;
    }

    private boolean isTargetAndMusicMatch(String targetNotes, Music music) {
        int startIndex = 0, endIndex = calcNoteLength(targetNotes) - 1;
        while (endIndex < music.playedDuration) {
            String subNotes = music.getSubNotes(startIndex, endIndex);
            if (targetNotes.equals(subNotes)) return true;
            startIndex++;
            endIndex++;
        }
        return false;
    }

    private int calcNoteLength(String notes) {
        int count = 0;
        for (int i = 0; i < notes.length(); i++) {
            count++;
            if (i + 1 < notes.length() && notes.charAt(i + 1) == '#') i++;
        }
        return count;
    }
    
    private boolean isUpdatable(Music result, Music music) {
        if (music.playedDuration > result.playedDuration) return true;
        return musics.indexOf(music) < musics.indexOf(result);
    }
}

class Music {
    int startTime;
    int endTime;
    int playedDuration;
    String title;
    List<String> originalNotes;
    List<String> playedNotes;

    public Music(String startTime, String endTime, String title, String notes) {
        this.startTime = parseTime(startTime);
        this.endTime = parseTime(endTime);
        playedDuration = this.endTime - this.startTime;
        this.title = title;
        this.originalNotes = parseOriginalNotes(notes);
        this.playedNotes = getPlayedNotes();
    }

    private int parseTime(String timeStr) {
        String[] time = timeStr.split(":");
        int hour = Integer.parseInt(time[0]);
        int minute = Integer.parseInt(time[1]);
        return hour * 60 + minute;
    }

    private List<String> parseOriginalNotes(String notes) {
        List<String> result = new ArrayList<>();
        String note;
        for (int i = 0; i < notes.length(); i++) {
            note = notes.charAt(i) + "";
            if (i + 1 < notes.length() && notes.charAt(i + 1) == '#') {
                note += "#";
                i++;
            }
            result.add(note);
        }
        return result;
    }

    private List<String> getPlayedNotes() {
        List<String> result = new ArrayList<>();
        if (this.playedDuration > this.originalNotes.size()) {
            for (int i = 0; i < this.playedDuration / this.originalNotes.size(); i++)
                result.addAll(originalNotes);
            for (int i = 0; i < this.playedDuration % this.originalNotes.size(); i++)
                result.add(this.originalNotes.get(i));
        } else {
            for (int i = 0; i < this.playedDuration; i++)
                result.add(this.originalNotes.get(i));
        }
        return result;
    }
    
    public String getSubNotes(int startIndex, int endIndex) {
        StringBuilder sb = new StringBuilder();
        for (int i = startIndex; i <= endIndex; i++)
            sb.append(this.playedNotes.get(i));
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Music)) return false;
        Music music = (Music) o;
        return Objects.equals(title, music.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title);
    }
}