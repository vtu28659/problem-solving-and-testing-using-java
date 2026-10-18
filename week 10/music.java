import java.util.*;
public class music {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> playlist = new ArrayList<>();
        System.out.print("Enter number of songs: ");
        int n = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter song names:");
        for (int i = 0; i < n; i++) {
            playlist.add(sc.nextLine());
        }
        System.out.println("Playlist: " + playlist);
        System.out.print("Enter song to remove: ");
        String song = sc.nextLine();
        if (playlist.remove(song)) {
            System.out.println("Song removed successfully.");
        } else {
            System.out.println("Song not found.");
        }
        System.out.println("Updated Playlist: " + playlist);
        sc.close();
    }
}
