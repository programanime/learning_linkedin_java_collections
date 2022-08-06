package com.linkedin;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class GuestService {

	private List<Guest> checkinList = new ArrayList<>(100);

	public static List<Guest> filterByFavoriteRoom(List<Guest> guests, Room room) {
		return guests.stream().filter(guest -> guest.getPreferredRooms().indexOf(room) == 0).collect(Collectors.toList());
	}

	public void checkIn(Guest guest) {
		checkinList.add(guest);

		List<Guest> programMembers = checkinList.stream().filter( g -> g.isLoyaltyProgramMember()).collect(Collectors.toList());
		List<Guest> notProgramMembers = checkinList.stream().filter(g -> !g.isLoyaltyProgramMember()).collect(Collectors.toList());
		List<Guest> newGuestList = new ArrayList<>(100);

		newGuestList.addAll(programMembers);
		newGuestList.addAll(notProgramMembers);
		checkinList = newGuestList;
	}
	
	public void swapPosition(Guest guest1, Guest guest2) {
		int indexGuest1 = checkinList.indexOf(guest1);
		int indexGuest2 = checkinList.indexOf(guest2);

		if(indexGuest1==-1 || indexGuest2==-1) {
			return;
		}

		checkinList.set(indexGuest1, guest2);
		checkinList.set(indexGuest2, guest1);
		/*
		 *  3.  Swaps the position of the two provided guests within the checkinList.
		 *  If guests are not currently in the list no action is required.
		 */ 

	}

	public List<Guest> getCheckInList() {
		return List.copyOf(this.checkinList);
	}
}
