package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Names {

    private final List<Name> names = new ArrayList<>();

    private Names(List<Name> names) {
        for (Name name : names) {
            this.names.add(name);
        }
    }

    public static Names from(String namesStr) {
        String[] nameList = namesStr.split(",");
        List<Name> names = new ArrayList<>();
        for (String name : nameList) {
            names.add(Name.from(name));
        }
        return new Names(names);
    }

    public static Names from(List<Name> names) {
        return new Names(names);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Names names1 = (Names) o;
        return Objects.equals(names, names1.names);
    }

    @Override
    public int hashCode() {
        return Objects.hash(names);
    }

}