package org.launchcode.professionalprocrastinators.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class LocationInformation {
    private String key;
    private String localizedName;
    private Region region;
    private TimeZone timeZone;
    @JsonProperty("Key")
    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }


    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }

    public TimeZone getTimeZone() {
        return timeZone;
    }

    public void setTimeZone(TimeZone timeZone) {
        this.timeZone = timeZone;
    }

    @JsonProperty("LocalizedName")
    public String getLocalizedName() {
        return localizedName;
    }

    public void setLocalizedName(String localizedName) {
        this.localizedName = localizedName;
    }

    public static class Region{
        private String englishName;
        @JsonProperty("EnglishName")
        public  String getEnglishName() {
            return englishName;
        }

        public void setEnglishName(String englishName) {
            englishName = englishName;
        }
    }
    public static class TimeZone{
        private String code;
        private String name;
        @JsonProperty("Code")
        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }
        @JsonProperty("Name")
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
