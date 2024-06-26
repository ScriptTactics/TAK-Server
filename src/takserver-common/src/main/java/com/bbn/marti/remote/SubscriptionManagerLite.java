

package com.bbn.marti.remote;

import java.security.PrivateKey;
import java.security.cert.X509Certificate;
import java.util.Collection;
import java.util.List;
import java.util.NavigableSet;
import java.util.Set;
import java.util.UUID;

import com.bbn.marti.config.GeospatialFilter;
import com.bbn.marti.remote.groups.Group;
import com.bbn.marti.remote.groups.User;
import com.bbn.marti.remote.socket.SituationAwarenessMessage;

public interface SubscriptionManagerLite {

    enum ChangeType { CONTENT, LOG, KEYWORD, METADATA, EXTERNAL_DATA, UID_KEYWORD, RESOURCE_KEYWORD, MISSION_DELETE, MISSION_CREATE, DATA_FEED, MAP_LAYER, MISSION_LAYER }

	RemoteSubscription getRemoteSubscriptionByClientUid(String cUid);
    RemoteSubscription getSubscriptionByClientUid(String cUid);
    RemoteSubscription getSubscriptionByCallsign(String callsign);
    RemoteSubscription getSubscriptionByUsersDisplayName(String displayName);
    List<RemoteSubscription> getSubscriptionList();
    List<RemoteSubscription> getCachedSubscriptionList(String groupVector, String sort, int direction, int page, int limit);
    List<RemoteSubscription> getSubscriptionsWithGroupAccess(String groupVector, boolean noFederates);
    User getSubscriptionUserByClientUid(String cUid);

    boolean deleteSubscription(String subscriptionName);
    boolean deleteSubscriptionssByCertificate(X509Certificate x509Certificate);
    boolean toggleIncognito(String subscriptionName);
	void addSubscription(RemoteSubscription toAdd);
    void addSubscription(String uid, NavigableSet<Group> groups, User user, String callsign, String team, String role, String takv);
    boolean setGeospatialFilterOnSubscription(String clientUid, GeospatialFilter filter);
  
    String getXpathForUid(String uid);
    void setXpathForUid(String uid, String xpath);
    
    // Mission subscription management
    void missionSubscribe(UUID missionGuid, String clientUid);
    void missionUnsubscribe(UUID missionGuid, String uid, String username, boolean disconnectOnly);
    void missionDisconnect(UUID missionGuid, String clientUid);
    void removeAllMissionSubscriptions(UUID missionGuid);

    List<String> getMissionSubscriptions(UUID missionGuid, boolean connectedOnly);
    void announceMissionChange(UUID missionGuid, String missionName, ChangeType changeType, String creatorUid, String tool, String changes, String xmlContentForNotification);
    void announceMissionChange(UUID missionGuid, String missionName, ChangeType changeType, String creatorUid, String tool, String changes);
    void announceMissionChange(UUID missionGuid, String missionName, String creatorUid, String tool, String changes);
    
    void broadcastMissionAnnouncement(UUID missionGuid, String missionName, String groupVector, String creatorUid, ChangeType changeType, String tool);
    void sendMissionInvite(UUID missionGuid, String missionName, String[] uids, String authorUid, String tool, String token, String roleXml);
    void sendMissionRoleChange(UUID missionGuid, String missionName, String uid, String authorUid, String tool, String roleXml);

    List<UUID> getMissionSubscriptionsForUid(String uid);
    
    // manage missions / content uids in core services 
    void putMissionContentUid(UUID missionGuid, String uid);
    void removeMissionContentUids(UUID missionGuid, Set<String> uids);
    Collection<String> getContentUidsForMission(UUID missionGuid);
    Collection<UUID> getMissionsForContentUid(String uid);
    Set<SituationAwarenessMessage> getLatestReachableSA(User destUser);


    // These don't belong here long term...
    X509Certificate[] getSigningCertChain();
    PrivateKey getSigningKey();
    long getSigningValidity();

    void setSubscriptionsMetricsForClientUid(String clientUid, RemoteSubscriptionMetrics subscriptionMetrics);
    RemoteSubscriptionMetrics getSubscriptionMetricsForClientUid(String clientUid);
	boolean deleteSubscriptionFromUI(String uid);

	void sendLatestReachableSA(String username);
	void sendGroupsUpdatedMessage(String username, String clientUid);
	
	/**
	 * Return a list of active subscriptions, with filtering options.
	 */
	List<RemoteSubscription> getSubscriptionsWithGroupAccess(String groupVector, boolean noFederates, Set<Group> filterWriteOnlyGroups);
	
	
	String linkWebsocketToExistingSub(String connectionId, String clientUid, String username);
	void unlinkWebsocketExistingSub(String connectionId, String clientUid);
}
