package ohm.softa.a05.model;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;


// wenn wir implements Comparable<Plant> kriegen wir keine Fehlermeldung, weil die klasse abstract ist
// und wir können die methoden der Interface auch in den Subklassen implementieren

abstract public class Plant implements Comparable<Plant> {

    private double height;
    private String family;
    private String name;

    protected Plant(double height, String family, String name) {
        if(family == null || family.length() == 0) throw new IllegalArgumentException("Specify a family");
        //if(StringUtils.isBlank(family)) throw new IllegalArgumentException("Specify a family");   // andere variante

        if(name == null || name.length() == 0) throw new IllegalArgumentException("Specify a name");
        //if(StringUtils.isBlank(name)) throw new IllegalArgumentException("Specify a name");   // andere variante

        if(height <= 0.0) throw new IllegalArgumentException("Height may not be less or equal zero");
        this.height = height;
        this.family = family;
        this.name = name;
    }

    public double getHeight() {
        return height;
    }

    public String getFamily() {
        return family;
    }

    public String getName(){
        return name;
    }

    public abstract PlantColor getColor();

    @Override
    public int compareTo(Plant plant) {

        if(this.height > plant.height)
            return 1;
        else if( this.height < plant.height)
            return -1;
        else
            return 0;

        // return Double.compare(getHeight(), o.getHeight());
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(getFamily())
                .append(getName())
                .append(getHeight())
                .append(getColor())
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("family", family)
                .append("name", name)
                .append("height", height)
                .append("color", getColor())
                .toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (!(o instanceof Plant)) return false;

        Plant plant = (Plant) o;

        return new EqualsBuilder()
                .append(getHeight(), plant.getHeight())
                .append(getFamily(), plant.getFamily())
                .append(getName(), plant.getName())
                .append(getColor(), plant.getColor())
                .isEquals();
    }
}
