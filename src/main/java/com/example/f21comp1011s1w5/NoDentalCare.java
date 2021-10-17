package com.example.f21comp1011s1w5;

import java.util.Arrays;
import java.util.List;

public class NoDentalCare {
    private String ageGroup, sex, race, educationLevel;
    private int noDentalCaresId, researchYear;


    private boolean isDentalVisit;

    public NoDentalCare(String ageGroup, String sex, String race, String educationLevel, int researchYear, boolean isDentalVisit) {
        setAgeGroup(ageGroup);
        setSex(sex);
        setRace(race);
        setEducationLevel(educationLevel);
        setResearchYear(researchYear);
        setIsDentalVisit(isDentalVisit);
        noDentalCaresId = 0;
    }

    public String getAgeGroup() {
        return ageGroup;
    }

    public String getSex() {
        return sex;
    }

    public String getRace() {
        return race;
    }

    public String getEducationLevel() {
        return educationLevel;
    }

    public int getResearchYear() {
        return researchYear;
    }

    public boolean getIsDentalVisit() {
        return isDentalVisit;
    }

    public int getNoDentalCaresId() {
        return noDentalCaresId;
    }

    public void setAgeGroup(String ageGroup) {
        List<String> validAgeGroups = Arrays.asList(
                "Under 18 years",
                "18–24 years",
                "25–34 years",
                "35–44 years",
                "45–54 years",
                "45–54 years",
                "65 years and over");
        if(validAgeGroups.contains(ageGroup)){
            this.ageGroup = ageGroup;
        } else {
            throw new IllegalArgumentException(String.format("Age group must be selected from %s", validAgeGroups));
        }
    }

    public void setSex(String sex) {
        List<String> validSexes = Arrays.asList("Male", "Female");
        if(validSexes.contains(sex)){
            this.sex = sex;
        } else {
            throw new IllegalArgumentException(String.format("Sex must be selected from %s", validSexes));
        }
    }

    public void setRace(String race) {
        List<String> validRaces = Arrays.asList(
                "White",
                "Black",
                "American Indian or Alaska Native",
                "Asian",
                "Hispanic or Latino",
                "2 or more races");
        if(validRaces.contains(race)){
            this.race = race;
        } else {
            throw new IllegalArgumentException(String.format("Race must be selected from %s", validRaces));
        }
    }

    public void setEducationLevel(String educationLevel) {
        List<String> validEducationLevels = Arrays.asList(
                "No high school diploma",
                "High school diploma",
                "Some college or more");
        if(validEducationLevels.contains(educationLevel)){
            this.educationLevel = educationLevel;
        } else {
            throw new IllegalArgumentException(String.format("Education Level must be selected from %s", validEducationLevels));
        }
    }

    public void setResearchYear(int researchYear) {
        List<Integer> validResearchYears = Arrays.asList(1997, 2005, 2010, 2018);
        if(validResearchYears.contains(researchYear)){
            this.researchYear = researchYear;
        } else {
            throw new IllegalArgumentException(String.format("Research year must be any of the years %d", validResearchYears));
        }
    }

    public void setIsDentalVisit(boolean isDentalVisit) {
        if (isDentalVisit == true || isDentalVisit == false)
        {
            this.isDentalVisit = isDentalVisit;
        } else {
            throw new IllegalArgumentException("Please enter either true or false only.");
        }
    }

    public void setNoDentalCaresId(int noDentalCaresId) {
        if (0 < noDentalCaresId){
            this.noDentalCaresId = noDentalCaresId;
        } else {
            throw new IllegalArgumentException("ID must be a positive integer");
        }
    }

    @Override
    public String toString() {
        return "INSERT INTO noDentalCares (ageGroup, sex, race, educationLevel, researchYear, isDentalVisit) " +
                "VALUES ('"+ageGroup+"','"+sex+"','"+race+"','"+educationLevel+"',"+researchYear+","+isDentalVisit+");";
    }
}