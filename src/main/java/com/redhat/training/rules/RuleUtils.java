/*
 Copyright (c) 2015 Red Hat, Inc.

 Redistribution and use in source and binary forms, with or without
 modification, are permitted provided that the following conditions are
 met:

   1. Redistributions of source code must retain the above copyright
   notice, this list of conditions and the following disclaimer.

   2. Redistributions in binary form must reproduce the above
   copyright notice, this list of conditions and the following
   disclaimer in the documentation and/or other materials provided
   with the distribution.

 THIS SOFTWARE IS PROVIDED BY RED HAT, INC. ``AS IS'' AND ANY EXPRESS
 OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 DISCLAIMED. IN NO EVENT SHALL RED HAT, INC. BE LIABLE FOR ANY DIRECT,
 INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION)
 HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT,
 STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING
 IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 POSSIBILITY OF SUCH DAMAGE.
 */
package com.redhat.training.rules;

import org.kie.api.builder.Message;
import org.kie.api.builder.Results;
import org.kie.api.builder.Message.Level;
import org.kie.api.runtime.KieContainer;

public class RuleUtils {

	public static boolean checkErrors(KieContainer container) {
		Results results = container.verify();
		boolean hasErrors = results.hasMessages(Level.ERROR);
		if (hasErrors) {
			for (Message message : results.getMessages()) {
				System.err.println(String.format(
						"Line: %1$s / Column: %2$s , Path: %3$s / Error Message: %4$s ",
						message.getLine(), message.getColumn(),
						message.getPath(),message.toString()));
			}
			
		}
		return hasErrors;
	}
}
