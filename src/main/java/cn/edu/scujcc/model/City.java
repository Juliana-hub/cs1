package cn.edu.scujcc.model;
import java.util.List;

import org.springframework.data.annotation.Id;

public class City {
	@Id
	private String Id;
	private String cityname;
    private List<Weather> weathers;
    private String status;
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getId() {
		return Id;
	}

	public List<Weather> getWeathers() {
		return weathers;
	}

	public void setWeathers(List<Weather> weathers) {
		this.weathers = weathers;
	}

	public void setId(String id) {
		Id = id;
	}

	public String getCityname() {
		return cityname;
	}

	public void setCityname(String cityname) {
		this.cityname = cityname;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cityname == null) ? 0 : cityname.hashCode());
		result = prime * result + ((weathers == null) ? 0 : weathers.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		City other = (City) obj;
		if (cityname == null) {
			if (other.cityname != null)
				return false;
		} else if (!cityname.equals(other.cityname))
			return false;
		if (weathers == null) {
			if (other.weathers != null)
				return false;
		} else if (!weathers.equals(other.weathers))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "City [Id=" + Id + ", cityname=" + cityname + ", weathers=" + weathers + ", status=" + status + "]";
	}
	

}
