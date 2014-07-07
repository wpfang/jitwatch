/*
 * Copyright (c) 2013, 2014 Chris Newland.
 * Licensed under https://github.com/AdoptOpenJDK/jitwatch/blob/master/LICENSE-BSD
 * Instructions: https://github.com/AdoptOpenJDK/jitwatch/wiki
 */
package com.chrisnewland.jitwatch.model.assembly;

import static com.chrisnewland.jitwatch.core.JITWatchConstants.C_SPACE;
import static com.chrisnewland.jitwatch.core.JITWatchConstants.S_NEWLINE;

import java.util.ArrayList;
import java.util.List;

import com.chrisnewland.jitwatch.util.StringUtil;

public class AssemblyBlock
{
	private String title;
	private List<AssemblyInstruction> instructions = new ArrayList<>();

	public AssemblyBlock()
	{
	}

	public void setTitle(String title)
	{
		this.title = title;
	}

	public String getTitle()
	{
		return title;
	}

	public void addInstruction(AssemblyInstruction instr)
	{
		instructions.add(instr);
	}

	public List<AssemblyInstruction> getInstructions()
	{
		return instructions;
	}

	public String toString()
	{
		return toString(0);
	}

	public String toString(int maxAnnotationWidth)
	{
		StringBuilder builder = new StringBuilder();

		if (title != null)
		{
			builder.append(StringUtil.repeat(C_SPACE, maxAnnotationWidth));

			builder.append(title).append(S_NEWLINE);
		}

		for (AssemblyInstruction instruction : instructions)
		{
			builder.append(instruction.toString(maxAnnotationWidth)).append(S_NEWLINE);
		}

		return builder.toString();
	}
}