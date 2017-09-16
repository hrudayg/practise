package com.threads.fina;

import java.util.Set;
import java.util.TreeSet;

public final class FinalUse {
	public final Set<String> planets = new TreeSet<>(); 
	
	public FinalUse() {
		planets.add("Mercury");
		planets.add("Venus");
		planets.add("Earth");
		planets.add("Mars");
		planets.add("Jupiter");
		planets.add("Saturn");
		planets.add("Uranus");
		planets.add("Neptune");
	}
	
	public static void main(String[] args) {
		FinalUse finalUse = new FinalUse();
		System.out.println(finalUse.planets);
		finalUse.planets.add("new planet");
		System.out.println(finalUse.planets);
	}
}
