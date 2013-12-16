package no.runsafe.inspectorgadget;

import no.runsafe.framework.RunsafePlugin;
import no.runsafe.framework.features.Events;
import no.runsafe.inspectorgadget.events.RightClick;

public class Plugin extends RunsafePlugin
{
	@Override
	protected void pluginSetup()
	{
		addComponent(Events.class);
		addComponent(RightClick.class);
	}
}
