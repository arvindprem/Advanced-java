package fr.arvind.iamcore.service.matching.impl;

import fr.arvind.iamcore.datamodel.Identity;
import fr.arvind.iamcore.service.matching.Match;

public class ContainsMatch implements Match<Identity> {
	
	
	@Override
	public boolean match(Identity firstIdentity, Identity secondIdentity) {
		return firstIdentity.getDisplayName().contains(secondIdentity.getDisplayName());
	}

}
