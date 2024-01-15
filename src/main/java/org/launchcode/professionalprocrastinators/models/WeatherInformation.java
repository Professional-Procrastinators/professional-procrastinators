package org.launchcode.professionalprocrastinators.models;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;

public class WeatherInformation {

    public static class DailyForecast {
        private String date;
        private Temperature temperature;
        private Day day;

        @JsonProperty("Date")
        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        @JsonSetter("Temperature")
        public Temperature getTemperature() {
            return temperature;
        }

        public void setTemperature(Temperature temperature) {
            this.temperature = temperature;
        }

        @JsonProperty("Day")
        public Day getDay() {
            return day;
        }

        public void setDay(Day day) {
            this.day = day;
        }

    }
    public static class Temperature{
        private Minimum minimum;
        private Maximum maximum;
        @JsonProperty("Minimum")
        public Minimum getMinimum() {
            return minimum;
        }
        public void setMinimum(Minimum minimum) {
            this.minimum = minimum;
        }
        @JsonProperty("Maximum")
        public Maximum getMaximum() {
            return maximum;
        }

        public void setMaximum(Maximum maximum) {
            this.maximum = maximum;
        }
    }
    public static class Minimum{
        private double value;
        private String unit;
        @JsonProperty("Value")
        public double getValue() {
            return value;
        }

        public void setValue(double value) {
            this.value = value;
        }
        @JsonProperty("Unit")
        public String getUnit() {
            return unit;
        }

        public void setUnit(String unit) {
            this.unit = unit;
        }
    }
    public static class Maximum{
        private double value;
        private String unit;
        @JsonProperty("Value")
        public double getValue() {
            return value;
        }

        public void setValue(double value) {
            this.value = value;
        }
        @JsonProperty("Unit")
        public String getUnit() {
            return unit;
        }

        public void setUnit(String unit) {
            this.unit = unit;
        }
    }
    public static class Day{
        private int icon;
        private String iconPhrase;
        private boolean hasPrecipitation;
        private String precipitationType;

        private int precipitationProbability;
    @JsonProperty("Icon")
        public int getIcon() {
            return icon;
        }

        public void setIcon(int icon) {
            this.icon = icon;
        }
    @JsonProperty("IconPhrase")
        public String getIconPhrase() {
            return iconPhrase;
        }

        public void setIconPhrase(String iconPhrase) {
            this.iconPhrase = iconPhrase;
        }
        @JsonProperty("HasPrecipitation")
        public boolean isHasPrecipitation() {
            return hasPrecipitation;
        }

        public void setHasPrecipitation(boolean hasPrecipitation) {
            this.hasPrecipitation = hasPrecipitation;
        }
        @JsonProperty("PrecipitationType")
        public String getPrecipitationType() {
            return precipitationType;
        }

        public void setPrecipitationType(String precipitationType) {
            this.precipitationType = precipitationType;
        }
        @JsonProperty("PrecipitationProbability")
        public int getPrecipitationProbability() {
            return precipitationProbability;
        }

        public void setPrecipitationProbability(int precipitationProbability) {
            this.precipitationProbability = precipitationProbability;
        }
    }

}