package exam02;

import java.util.ArrayList;
import java.util.List;

public class Cv {

    private String name;
    private List<Skill> skills = new ArrayList<>();

    public Cv(String name, List<Skill> skills) {
        this.name = name;
        this.skills = skills;
    }

    public Cv(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public List<Skill> getSkills() {
        return new ArrayList<>(skills);
    }

    public void addSkills(String... skillsAndLevels) {
        for (String item : skillsAndLevels) {
            String skillName = item.substring(0, item.length() - 4);
            int skillLevel = Integer.parseInt(item.substring(item.length() - 2, item.length() - 1));
            skills.add(new Skill(skillName, skillLevel));
        }
    }

    public int findSkillLevelByName(String name) {

        if (skills.size() == 0) {
            throw new IllegalArgumentException();
        }
        int level = 0;
        for (Skill s : skills) {
            if (s.getName().equals(name)) {
                level = s.getLevel();
            }
        }
        return level;
    }

}




//Egy önéletrajzot reprezentáló osztályt kell létrehozni, melyben van egy név, valamint skillek (hogy mihez ért az illető).
// A skill egy névvel és egy számmal (szint) rendelkezik, utóbbi 1 - 5 között.
//
//Az önéletrajz a Cv osztály pár metódussal, a skill a Skill osztály.
//
//A skillek megadása a nevével, valamint a szintjével történik, pl. "programming (5)".
//
//A findSkillLevelByName() a skill neve alapján visszaadja annak szintjét.
