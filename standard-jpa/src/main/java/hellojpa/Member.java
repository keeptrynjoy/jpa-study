package hellojpa;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Member {//extends BaseEntity{

    @Id @GeneratedValue
    @Column(name = "MEMBER_ID")
    private Long id;

    @Column(name = "USERNAME")
    private String userName;

    @Embedded
    private Address homeAddress;

    @ElementCollection
    @CollectionTable(name = "FAVORITE_FOOD",joinColumns = @JoinColumn(name = "MEMBER_ID"))
    @Column(name = "FOOD_NAME")
    private Set<String> favoriteFoods = new HashSet<>();

//    @ElementCollection
//    @CollectionTable(name = "ADDRESS",joinColumns = @JoinColumn(name = "MEMBER_ID"))
//    private List<Address> addressHistory = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "MEMBER_ID")
    private List<AddressEntity> addressHistory = new ArrayList<>();

    public Set<String> getFavoriteFoods() {
        return favoriteFoods;
    }

    public void setFavoriteFoods(Set<String> favoriteFoods) {
        this.favoriteFoods = favoriteFoods;
    }
//
//    public List<Address> getAddressHistory() {
//        return addressHistory;
//    }

    public List<AddressEntity> getAddressHistory() {
        return addressHistory;
    }

    public void setAddressHistory(List<AddressEntity> addressHistory) {
        this.addressHistory = addressHistory;
    }


//    public void setAddressHistory(List<Address> addressHistory) {
//        this.addressHistory = addressHistory;
//    }

//    @Embedded
//    private Address homeAddress;

//    @Embedded
//    @AttributeOverrides({
//                @AttributeOverride(name = "city",
//                        column = @Column(name = "WORK_CITY")),
//                @AttributeOverride(name = "street",
//                        column = @Column(name = "WORK_STREET")),
//                @AttributeOverride(name = "zipcode",
//                        column = @Column(name = "WORK_ZIPCODE"))
//        })
//    private Address workAddress;

//    @Column(name = "TEAM_ID")
//    private Long teamId;

//    @ManyToOne(fetch = FetchType.EAGER)
//    @JoinColumn(name = "Team_ID")
//    private Team team;
////
//    @OneToOne
//    @JoinColumn(name="LOCKER_ID")
//    private Locker locker;

//    public Member() {
//    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

//    public Period getWorkPeriod() {
//        return workPeriod;
//    }

//    public void setWorkPeriod(Period workPeriod) {
//        this.workPeriod = workPeriod;
//    }

    public Address getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(Address homeAddress) {
        this.homeAddress = homeAddress;
    }
//    public Team getTeam() {
//        return team;
//    }
//
//    public void setTeam(Team team) {
//        this.team = team;
//    }
//
//    public void changeTeam(Team team) {
//        this.team = team;
//        team.getMembers().add(this);
//    }
//
//    public Long getTeamId() {
//        return teamId;
//    }
//
//    public void setTeamId(Long teamId) {
//        this.teamId = teamId;
//    }
}
