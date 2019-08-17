package chat.maisy.constant;

public enum Status {
    // RUN, STOP, ERROR

    RUN() {
        public String key = "RUN";

        public String print() {
            return "running";
        }
    },
    STOP(){
        public String key = "STOP";

        public String print() {
            return "stopped";
        }
    },
    ERROR(){
    	public String key = "ERROR";
    	
    	public String print() {
    		return "has error";
    	}
    },
    CONNECTED(){
        public String key = "CONN";

        public String print() {
            return "connected";
        }
    };

    public abstract String print();
    public String key;
}