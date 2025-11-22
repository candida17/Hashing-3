// Time Complexity : O(U*S) where U is number of users and s is number of songs
// Space Complexity : O(S)
// Did this code successfully run on Leetcode : Yes 
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach
// We map each song to its genre in songsToGenre map
// We go over the songs of each user and check to which genre the song belongs to and further create genre count map
// we keep increementing the count of genre and the genre with max count will be mapped to user.
import java.util.*;
public class Main {
    
    public static Map<String, List<String>> favoritegenre(HashMap<String, List<String>> userMap, HashMap<String, List<String>> genreMap) {
        HashMap<String, String> songsToGenre = new HashMap<>();
        Map<String, List<String>> res = new HashMap<>();
        //create song to genre map
        for(String genre: genreMap.keySet()){
            List<String> songs = genreMap.get(genre);
            for(String song: songs){
                songsToGenre.put(song, genre);
            }
        }
        //iterate over each users 
        for(String user: userMap.keySet()) {
            List<String> songs = userMap.get(user);
            //create empty list for the individual user
            res.put(user, new ArrayList<>());
            //count map to store the max genre of a user
            HashMap<String, Integer> countMap = new HashMap<>();
            int maxCount =0;
            for(String song: songs){
                //get the genre for the songs of user
                String genre = songsToGenre.get(song);
                countMap.put(genre, countMap.getOrDefault(genre, 0)+1);
                maxCount = Math.max(maxCount, countMap.get(genre));
            }
            //itertae over the count map and get the max genre
            for(String genre: countMap.keySet()) {
                if(countMap.get(genre) == maxCount) {
                    res.get(user).add(genre);
                }
            }
        }
        return res;
    }
    public static void main(String[] args) {
            HashMap<String, List<String>> userSongs = new HashMap<>();
    
            userSongs.put("David", Arrays.asList(new String[]{"song1", "song2", "song3", "song4", "song8"}));
    
            userSongs.put("Emma", Arrays.asList(new String[]{"song5", "song6", "song7"}));
    
            HashMap<String, List<String>> songGenres = new HashMap<>();
    
            songGenres.put("Rock", Arrays.asList(new String[]{"song1", "song3"}));
    
            songGenres.put("Dubstep", Arrays.asList(new String[]{"song7"}));
    
            songGenres.put("Techno", Arrays.asList(new String[]{"song2", "song4"}));
    
            songGenres.put("Pop", Arrays.asList(new String[]{"song5", "song6"}));
    
            songGenres.put("Jazz", Arrays.asList(new String[]{"song8", "song9"}));
    
            Map<String, List<String>> res = favoritegenre(userSongs, songGenres);
    
            System.out.println(res);
    }
}
