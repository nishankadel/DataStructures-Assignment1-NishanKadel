package ArtifactVault;

import java.util.Arrays;

public class ArtifactVault {
	private String[] artifacts;
	private int count;
	
	public ArtifactVault(int size) {
        artifacts = new String[size];
        count = 0;
    }

    public boolean addArtifact(String artifact) {
        if (count < artifacts.length) {
            artifacts[count] = artifact;
            count++;
            Arrays.sort(artifacts, 0, count);  
            return true;
        } else {
            System.out.println("Sorry! Vault is full.");
            return false;
        }
    }
    
    public boolean removeArtifact(String artifact) {
        for (int i = 0; i < count; i++) {
            if (artifacts[i].equals(artifact)) {
                for (int j = i; j < count - 1; j++) {
                    artifacts[j] = artifacts[j + 1];
                }
                artifacts[count - 1] = null;
                count--;
                Arrays.sort(artifacts, 0, count);
                return true;
            }
        }
        System.out.println("Artifact not found.");
        return false;
    }
    
    public int findArtifactLinear(String artifact) {
        for (int i = 0; i < count; i++) {
            if (artifacts[i].equals(artifact)) {
                return i;
            }
        }
        System.out.println("Artifact not found in linear search.");
        return -1;
    }

    public int findArtifactBinary(String artifact) {
        int low = 0, high = count - 1;
        
        while (low <= high) {
            int mid = (low + high) / 2;

            
            if (artifacts[mid] == null) {
                break; 
            }

            if (artifacts[mid].equals(artifact)) {
                return mid;
            } else if (artifacts[mid].compareTo(artifact) < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return -1; 
    }

    public void displayArtifacts() {
        System.out.println("All Artifacts in the vault:");
        for (int i = 0; i < count; i++) {
            System.out.println(artifacts[i]);
        }
    }
    
	public static void main(String[] args) {
ArtifactVault vault = new ArtifactVault(5);
        
        // Adding artifacts
        vault.addArtifact("Golden Idol");
        vault.addArtifact("Holy Grail");
        vault.addArtifact("Crystal Skull");
        vault.addArtifact("Ark of the Covenant");
        vault.addArtifact("Sankara Stones");

        vault.displayArtifacts();

        vault.removeArtifact("Holy Grail");

        vault.displayArtifacts();

        int linearIndex = vault.findArtifactLinear("Crystal Skull");
        System.out.println("Linear Search has found Crystal Skull at an index of : " + linearIndex);

        int binaryIndex = vault.findArtifactBinary("Sankara Stones");
        System.out.println("Binary Search has found Sankara Stones at an index of : " + binaryIndex);


	}

}
