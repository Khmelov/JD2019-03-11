package by.it.eslaikouskaya.project.java.controllers;

import javax.servlet.http.HttpServletRequest;

public enum Actions {

	SEARCH(new CmdSearch()),
	EDITUSERS(new CmdEditUsers()),
	CREATECATEGORY(new CmdCreateCategory()),
	CREATEGRADE(new CmdCreateGrade()),
	CREATEMAT(new CmdCreateMat()),
	INDEX(new CmdIndex()),
	RESETDB(new CmdResetDB()),
	LOGIN(new CmdLogin()),
	PROFILE(new CmdProfile()),
	SIGNUP(new CmdSignup()),
	ERROR(new CmdError());

	public Cmd command;

	Actions(Cmd command) {
		this.command = command;
	}

	static Cmd defineCommand(HttpServletRequest req) {
		String nameCommand = req.getParameter("command");
		if (nameCommand == null)
			return Actions.INDEX.command;
		try {
			return Actions.valueOf(nameCommand.toUpperCase()).command;
		} catch (IllegalArgumentException e) {
			return Actions.ERROR.command;
		}
	}

}
