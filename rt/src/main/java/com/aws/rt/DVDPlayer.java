package com.example.topcoder;

//Problem Area
//		Problem Statement
//		You own a large selection of DVDs that you and your friends enjoy. Unfortunately, your friends aren't the most considerate bunch, so each DVD is not necessarily returned to its respective case. When your friends want to watch a movie, they go through each of your DVD cases one by one until they find the movie they want to watch. They then take that DVD out, and switch it with the one that's currently in the player.
//
//		You will be given a moviesWatched: a list of all the movies watched in an unspecified time period, in the order they were watched. Assume you only own one copy of each movie. The DVD player is initially empty, and each DVD starts in its own case. You should return a where each element describes a movie that is in a different movie's case after all DVDs in moviesWatched have been viewed. These elements should be of the format " is inside 's case". The list should be ordered alphabetically by the title of . The last DVD in moviesWatched will still be in the DVD player at the end of the simulation, so it should never appear as in the returned list.
//
//		Definition
//		Class: DVDPlayer
//		Method: findMovies
//		Parameters: String[]
//		Returns: String[]
//		Method signature: String[] findMovies(String[] moviesWatched)
//		(be sure your method is public)
//		Limits
//		Time limit (s): 840.000
//		Memory limit (MB): 64
//		Constraints
//		- moviesWatched will contain between 2 and 50 elements, inclusive.
//		- Each element of moviesWatched will contain between 1 and 20 characters, inclusive.
//		- Each element of moviesWatched will consist of only lowercase letters ('a' - 'z').
//		- No two consecutive elements of moviesWatched will be equal.
//		Examples
//		0)
//		{"citizenkane", "casablanca", "thegodfather"}
//		Returns: {"casablanca is inside thegodfather's case", "citizenkane is inside casablanca's case" }
//		Your friends first remove Citizen Kane from its DVD case and put it in the player. They then look for Casablanca, find it in its own case, and swap it with the DVD in the player. Finally, they look for The Godfather, find it in its own case, and swap it with Casablanca. Note that the output is sorted alphabetically, with "casablanca" before "citizenkane".
//		1)
//		{"starwars", "empirestrikesback", "returnofthejedi", "empirestrikesback", "returnofthejedi", "phantommenace", "starwars"}
//		Returns: {"empirestrikesback is inside returnofthejedi's case", "phantommenace is inside empirestrikesback's case", "returnofthejedi is inside phantommenace's case" }
//		After the first time your friends watch Star Wars, they put it in the Empire Strikes Back DVD case. When they want to watch it the second time, they find the case that it's in and swap it with Phantom Menace, the disk currently in the DVD player. Therefore, Phantom Menace ends up in the Empire Strikes Back's case.
//		2)
//		{"a", "x", "a", "y", "a", "z", "a"}
//		Returns: { }
//		All movies are back in their original cases (except movie "a", which is in the DVD player).


// https://arena.topcoder.com/#/u/practiceCode/1556/4411/4781/2/1556

import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Collections;

public class DVDPlayer {
	public String[] findMovies(String[] moviesWatched){
		Map<String, String> map = new HashMap<String,String>();
		Map<String, String> all = new HashMap<String,String>();

		for(int i = 0; i < moviesWatched.length-1; i++){
			//System.out.println(moviesWatched[i]+":"+moviesWatched[i+1]);

			all.put(moviesWatched[i], "");
			if (all.containsKey(moviesWatched[i+1])){
				//System.out.println("exist:"+moviesWatched[i+1]);

				for(Map.Entry<String, String> entry : map.entrySet()){
					String mapKey = entry.getKey();
					String mapValue = entry.getValue();
					//System.out.println("map-"+mapKey+":"+mapValue);
					if (mapValue == moviesWatched[i+1]){
						map.put(mapKey, moviesWatched[i]);
					}
				}
			} else {
				//System.out.println("not exist:"+moviesWatched[i+1]);
				map.put(moviesWatched[i+1], moviesWatched[i]);
			}

		}

		ArrayList<String> list=new ArrayList<String>();
		for(Map.Entry<String, String> entry : map.entrySet()){
			String mapKey = entry.getKey();
			String mapValue = entry.getValue();
			if ( mapKey != mapValue){
				String s = mapValue+" is inside "+ mapKey + "'s case";
				list.add(s);
			}
		}
		Collections.sort(list);
		String[] strings = new String[list.size()];
		list.toArray(strings);

		return strings;
	}

	public static final void main(String[] args){
//		String[] moviesWatched = new String[]{"citizenkane", "casablanca", "thegodfather"};
//		String[] r = new String[]{"casablanca is inside thegodfather's case", "citizenkane is inside casablanca's case" };


//		String[] moviesWatched = new String[]{"starwars", "empirestrikesback", "returnofthejedi", "empirestrikesback", "returnofthejedi", "phantommenace", "starwars"};
//		String[] r = new String[]{"empirestrikesback is inside returnofthejedi's case", "phantommenace is inside empirestrikesback's case", "returnofthejedi is inside phantommenace's case" };


		String[] moviesWatched = new String[]{"a", "x", "a", "y", "a", "z", "a"};
//		String[] r = new String[]{};

		DVDPlayer d = new DVDPlayer();
		String[] ret  = d.findMovies(moviesWatched);
		for (String s: ret){
			System.out.println(s);
		}
	}
}
