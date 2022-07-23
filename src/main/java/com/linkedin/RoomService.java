package com.linkedin;

import java.lang.annotation.Target;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

import javax.xml.transform.Source;

public class RoomService {
 
	private Collection<Room> inventory;

	void something(){
		Map<String,String> map = new TreeMap<>();
		map.put("name", "daniel");
		map.put("age", "zack");
		map.keySet().stream().forEach(System.out::println);
		map.values().stream().forEach(System.out::println);
		map.entrySet().stream().forEach(System.out::println);
	}

	public RoomService() {
		this.inventory = new LinkedHashSet<>();
	}
	
	public void applyDiscount(final double discount) {
		
		//Reduces the rate of each room by the provided discount
		final double percentOfTotal = 1 - discount;
		this.inventory.forEach(r -> r.setRate(r.getRate() * percentOfTotal));
	
	}

	public Collection<Room> getRoomsByCapacity(final int requiredCapacity) {
		
		//Returns a new collection of rooms that meet or exceed the provided capacity
		
		Collection<Room> matches = new HashSet<>();
		
		for(Room room : this.inventory) {
			
			if(room.getCapacity() >= requiredCapacity) {
				matches.add(room);
			}
		}
		
		return matches;
	}
	
	public Collection<Room> getRoomByRateAndType(final double rate, final String type){
	
		//Returns a new collection of rooms with a rate below the provided rate and that match the provided type
		
		return this.inventory.stream()
				.filter(r -> r.getRate() <= rate)
				.filter(r -> r.getType().equals(type))
				.collect(Collectors.toList());
	}
	
	public boolean hasRoom(Room room) {
		
		return this.inventory.contains(room); 
	}
	
	public Room[] asArray() {
		
		return this.inventory.toArray(new Room[0]);
	}
	
	public Collection<Room> getByType(String type){

		Collection<Room> copy = new HashSet<>(this.inventory);
		copy.removeIf(r -> !r.getType().equals(type));
		return copy;
		
	}

	public Collection<Room> getInventory() {
		return new HashSet<>(this.inventory); 
	}

	public void createRoom(String name, String type, int capacity, double price) {
		this.inventory.add(new Room(name, type, capacity, price));
	}

	public void createRooms(Room[] rooms) {
		this.inventory.addAll(Arrays.asList(rooms));
	}

	public void removeRoom(Room room) {
		this.inventory.remove(room);
	}
}
