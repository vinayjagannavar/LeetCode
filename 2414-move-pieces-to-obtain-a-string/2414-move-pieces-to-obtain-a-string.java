class Solution {
    public boolean canChange(String start, String target) {
        int startPointer = 0;
        int targetPointer = 0;

        String startStripped = start.replace("_", "");
        String targetStripped = target.replace("_", "");
        if (!startStripped.equals(targetStripped)) {
            return false;
        }

        // Compare positions of 'L' and 'R'
        while (startPointer < start.length() && targetPointer < target.length()) {
            // Skip underscores in `start`
            while (startPointer < start.length() && start.charAt(startPointer) == '_') {
                startPointer++;
            }
            // Skip underscores in `target`
            while (targetPointer < target.length() && target.charAt(targetPointer) == '_') {
                targetPointer++;
            }

            // If both pointers are within bounds
            if (startPointer < start.length() && targetPointer < target.length()) {
                char startChar = start.charAt(startPointer);
                char targetChar = target.charAt(targetPointer);

                // Check if characters match and are in valid positions
                if (startChar != targetChar || 
                    (startChar == 'L' && startPointer < targetPointer) || 
                    (startChar == 'R' && startPointer > targetPointer)) {
                    return false;
                }

                // Move to the next positions
                startPointer++;
                targetPointer++;
            }
        }

        return true;
    }
}