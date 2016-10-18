package br.com.myproject.enums;

public enum CommandWord {
	
	GO("go") {
		@Override
		public String execute() {
			System.out.println("Substitute Switchcase GO");
			return "GO";
			
		}
	}, LOOK("look") {
		@Override
		public String execute() {
			System.out.println("Substitute Switchcase LOOK");
			return "GO";
			
		}
	}, TAKE("take") {
		@Override
		public String execute() {
			System.out.println("Substitute Switchcase TAKE");
			return "GO";
			
		}
	}, HELP("help") {
		@Override
		public String execute() {
			System.out.println("Substitute Switchcase HELP");
			return "GO";
			
		}
	}, QUIT("quit") {
		@Override
		public String execute() {
			System.out.println("Substitute Switchcase QUIT");
			return "GO";
		}
	};
	
	private String commandString;
	
	CommandWord(String commandString) {
		this.commandString = commandString;
	}
	
	public String toString() {
		return commandString;
	}
	
	public abstract String execute();
}
