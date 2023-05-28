package foo.guilherme.extensions.handler;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.wso2.carbon.identity.base.IdentityRuntimeException;
import org.wso2.carbon.identity.core.bean.context.MessageContext;
import org.wso2.carbon.identity.core.handler.InitConfig;
import org.wso2.carbon.identity.event.IdentityEventConstants;
import org.wso2.carbon.identity.event.IdentityEventException;
import org.wso2.carbon.identity.event.event.Event;
import org.wso2.carbon.identity.event.handler.AbstractEventHandler;

public class LoginReporter extends AbstractEventHandler {
    private static final Logger log = LogManager.getLogger(LoginReporter.class.getName());
    @Override
    public String getName() {
        return "loginReporter";
    }

    @Override
    public int getPriority(MessageContext messageContext) {
        return 50;
    }

    public void handleEvent(Event event) throws IdentityEventException {
        if (IdentityEventConstants.Event.POST_AUTHENTICATION.equals(event.getEventName())) {
            // Handling after the user authenticated
            log.info("User authenticated.");
            String username = (String) event.getEventProperties().get(IdentityEventConstants.EventProperty.USER_NAME);
            String email = (String) event.getEventProperties().get(IdentityEventConstants.EventProperty.VERIFIED_EMAIL);
            log.info("Authenticated user " + username + " with email " + email + " <-- email. ");
        }
    }

    @Override
    public void init(InitConfig configuration) throws IdentityRuntimeException {

        super.init(configuration);
    }
}
