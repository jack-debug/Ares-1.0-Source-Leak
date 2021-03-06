package com.google.cloud.storage;

import com.google.cloud.StringEnumType;
import com.google.api.core.ApiFunction;
import com.google.cloud.StringEnumValue;
import java.util.Objects;
import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.api.services.storage.model.BucketAccessControl;
import com.google.api.services.storage.model.ObjectAccessControl;
import com.google.common.base.Function;
import java.io.Serializable;

public final class Acl implements Serializable
{
    private static final long serialVersionUID = 7516713233557576082L;
    static final Function<ObjectAccessControl, Acl> FROM_OBJECT_PB_FUNCTION;
    static final Function<BucketAccessControl, Acl> FROM_BUCKET_PB_FUNCTION;
    private final Entity entity;
    private final Role role;
    private final String id;
    private final String etag;
    
    private Acl(final Builder a1) {
        this.entity = Preconditions.<Entity>checkNotNull(a1.entity);
        this.role = Preconditions.<Role>checkNotNull(a1.role);
        this.id = a1.id;
        this.etag = a1.etag;
    }
    
    public Entity getEntity() {
        /*SL:409*/return this.entity;
    }
    
    public Role getRole() {
        /*SL:414*/return this.role;
    }
    
    public String getId() {
        /*SL:419*/return this.id;
    }
    
    public String getEtag() {
        /*SL:428*/return this.etag;
    }
    
    public Builder toBuilder() {
        /*SL:433*/return new Builder(this);
    }
    
    public static Acl of(final Entity a1, final Role a2) {
        /*SL:443*/return newBuilder(a1, a2).build();
    }
    
    public static Builder newBuilder(final Entity a1, final Role a2) {
        /*SL:453*/return new Builder(a1, a2);
    }
    
    @Override
    public String toString() {
        /*SL:458*/return MoreObjects.toStringHelper((Object)this).add("entity", (Object)this.entity).add(/*EL:459*/"role", (Object)this.role).add(/*EL:460*/"etag", (Object)this.etag).add(/*EL:461*/"id", (Object)this.id).toString();
    }
    
    @Override
    public int hashCode() {
        /*SL:468*/return Objects.hash(this.entity, this.role);
    }
    
    @Override
    public boolean equals(final Object a1) {
        /*SL:473*/if (this == a1) {
            /*SL:474*/return true;
        }
        /*SL:476*/if (a1 == null || this.getClass() != a1.getClass()) {
            /*SL:477*/return false;
        }
        final Acl v1 = /*EL:479*/(Acl)a1;
        /*SL:480*/return Objects.equals(this.entity, v1.entity) && /*EL:481*/Objects.equals(this.role, v1.role) && /*EL:482*/Objects.equals(this.etag, v1.etag) && /*EL:483*/Objects.equals(this.id, v1.id);
    }
    
    BucketAccessControl toBucketPb() {
        final BucketAccessControl v1 = /*EL:487*/new BucketAccessControl();
        /*SL:488*/v1.setEntity(this.getEntity().toString());
        /*SL:489*/v1.setRole(this.getRole().toString());
        /*SL:490*/v1.setId(this.getId());
        /*SL:491*/v1.setEtag(this.getEtag());
        /*SL:492*/return v1;
    }
    
    ObjectAccessControl toObjectPb() {
        final ObjectAccessControl v1 = /*EL:496*/new ObjectAccessControl();
        /*SL:497*/v1.setEntity(this.getEntity().toPb());
        /*SL:498*/v1.setRole(this.getRole().name());
        /*SL:499*/v1.setId(this.getId());
        /*SL:500*/v1.setEtag(this.getEtag());
        /*SL:501*/return v1;
    }
    
    static Acl fromPb(final ObjectAccessControl a1) {
        final Role v1 = /*EL:505*/Role.valueOf(a1.getRole());
        final Entity v2 = /*EL:506*/Entity.fromPb(a1.getEntity());
        /*SL:507*/return newBuilder(v2, v1).setEtag(a1.getEtag()).setId(/*EL:508*/a1.getId()).build();
    }
    
    static Acl fromPb(final BucketAccessControl a1) {
        final Role v1 = /*EL:514*/Role.valueOf(a1.getRole());
        final Entity v2 = /*EL:515*/Entity.fromPb(a1.getEntity());
        /*SL:516*/return newBuilder(v2, v1).setEtag(a1.getEtag()).setId(/*EL:517*/a1.getId()).build();
    }
    
    static {
        FROM_OBJECT_PB_FUNCTION = new Function<ObjectAccessControl, Acl>() {
            @Override
            public Acl apply(final ObjectAccessControl a1) {
                /*SL:44*/return Acl.fromPb(a1);
            }
        };
        FROM_BUCKET_PB_FUNCTION = new Function<BucketAccessControl, Acl>() {
            @Override
            public Acl apply(final BucketAccessControl a1) {
                /*SL:51*/return Acl.fromPb(a1);
            }
        };
    }
    
    public static final class Role extends StringEnumValue
    {
        private static final long serialVersionUID = 123037132067643600L;
        private static final ApiFunction<String, Role> CONSTRUCTOR;
        private static final StringEnumType<Role> type;
        public static final Role OWNER;
        public static final Role READER;
        public static final Role WRITER;
        
        private Role(final String a1) {
            super(a1);
        }
        
        public static Role valueOfStrict(final String a1) {
            /*SL:86*/return (Role)Role.type.valueOfStrict(a1);
        }
        
        public static Role valueOf(final String a1) {
            /*SL:91*/return (Role)Role.type.valueOf(a1);
        }
        
        public static Role[] values() {
            /*SL:96*/return (Role[])Role.type.values();
        }
        
        static {
            CONSTRUCTOR = (ApiFunction)new ApiFunction<String, Role>() {
                public Role apply(final String a1) {
                    /*SL:71*/return new Role(a1);
                }
            };
            type = new StringEnumType((Class)Role.class, (ApiFunction)Role.CONSTRUCTOR);
            OWNER = (Role)Role.type.createAndRegister("OWNER");
            READER = (Role)Role.type.createAndRegister("READER");
            WRITER = (Role)Role.type.createAndRegister("WRITER");
        }
    }
    
    public static class Builder
    {
        private Entity entity;
        private Role role;
        private String id;
        private String etag;
        
        private Builder(final Entity a1, final Role a2) {
            this.entity = a1;
            this.role = a2;
        }
        
        private Builder(final Acl a1) {
            this.entity = a1.entity;
            this.role = a1.role;
            this.id = a1.id;
            this.etag = a1.etag;
        }
        
        public Builder setEntity(final Entity a1) {
            /*SL:122*/this.entity = a1;
            /*SL:123*/return this;
        }
        
        public Builder setRole(final Role a1) {
            /*SL:128*/this.role = a1;
            /*SL:129*/return this;
        }
        
        Builder setId(final String a1) {
            /*SL:133*/this.id = a1;
            /*SL:134*/return this;
        }
        
        Builder setEtag(final String a1) {
            /*SL:138*/this.etag = a1;
            /*SL:139*/return this;
        }
        
        public Acl build() {
            /*SL:144*/return new Acl(this, null);
        }
    }
    
    public abstract static class Entity implements Serializable
    {
        private static final long serialVersionUID = -2707407252771255840L;
        private final Type type;
        private final String value;
        
        Entity(final Type a1, final String a2) {
            this.type = a1;
            this.value = a2;
        }
        
        public Type getType() {
            /*SL:171*/return this.type;
        }
        
        protected String getValue() {
            /*SL:176*/return this.value;
        }
        
        @Override
        public boolean equals(final Object a1) {
            /*SL:181*/if (this == a1) {
                /*SL:182*/return true;
            }
            /*SL:184*/if (a1 == null || this.getClass() != a1.getClass()) {
                /*SL:185*/return false;
            }
            final Entity v1 = /*EL:187*/(Entity)a1;
            /*SL:188*/return Objects.equals(this.type, v1.type) && Objects.equals(this.value, v1.value);
        }
        
        @Override
        public int hashCode() {
            /*SL:193*/return Objects.hash(this.type, this.value);
        }
        
        @Override
        public String toString() {
            /*SL:198*/return this.toPb();
        }
        
        String toPb() {
            /*SL:202*/return this.type.name().toLowerCase() + "-" + this.getValue();
        }
        
        static Entity fromPb(final String v-1) {
            /*SL:206*/if (v-1.startsWith("user-")) {
                /*SL:207*/return new User(v-1.substring(5));
            }
            /*SL:209*/if (v-1.equals("allUsers")) {
                /*SL:210*/return User.ofAllUsers();
            }
            /*SL:212*/if (v-1.equals("allAuthenticatedUsers")) {
                /*SL:213*/return User.ofAllAuthenticatedUsers();
            }
            /*SL:215*/if (v-1.startsWith("group-")) {
                /*SL:216*/return new Group(v-1.substring(6));
            }
            /*SL:218*/if (v-1.startsWith("domain-")) {
                /*SL:219*/return new Domain(v-1.substring(7));
            }
            /*SL:221*/if (v-1.startsWith("project-")) {
                final int a1 = /*EL:222*/v-1.indexOf(45, 8);
                final String v1 = /*EL:223*/v-1.substring(8, a1);
                final String v2 = /*EL:224*/v-1.substring(a1 + 1);
                /*SL:225*/return new Project(Project.ProjectRole.valueOf(v1.toUpperCase()), v2);
            }
            /*SL:227*/return new RawEntity(v-1);
        }
        
        public enum Type
        {
            DOMAIN, 
            GROUP, 
            USER, 
            PROJECT, 
            UNKNOWN;
        }
    }
    
    public static final class Domain extends Entity
    {
        private static final long serialVersionUID = -3033025857280447253L;
        
        public Domain(final String a1) {
            super(Type.DOMAIN, a1);
        }
        
        public String getDomain() {
            /*SL:247*/return this.getValue();
        }
    }
    
    public static final class Group extends Entity
    {
        private static final long serialVersionUID = -1660987136294408826L;
        
        public Group(final String a1) {
            super(Type.GROUP, a1);
        }
        
        public String getEmail() {
            /*SL:267*/return this.getValue();
        }
    }
    
    public static final class User extends Entity
    {
        private static final long serialVersionUID = 3076518036392737008L;
        private static final String ALL_USERS = "allUsers";
        private static final String ALL_AUTHENTICATED_USERS = "allAuthenticatedUsers";
        
        public User(final String a1) {
            super(Type.USER, a1);
        }
        
        public String getEmail() {
            /*SL:289*/return this.getValue();
        }
        
        @Override
        String toPb() {
            final String value = /*EL:294*/this.getValue();
            switch (value) {
                case "allAuthenticatedUsers": {
                    /*SL:296*/return "allAuthenticatedUsers";
                }
                case "allUsers": {
                    /*SL:298*/return "allUsers";
                }
                default: {
                    /*SL:302*/return super.toPb();
                }
            }
        }
        
        public static User ofAllUsers() {
            /*SL:306*/return new User("allUsers");
        }
        
        public static User ofAllAuthenticatedUsers() {
            /*SL:310*/return new User("allAuthenticatedUsers");
        }
    }
    
    public static final class Project extends Entity
    {
        private static final long serialVersionUID = 7933776866530023027L;
        private final ProjectRole projectRole;
        private final String projectId;
        
        public Project(final ProjectRole a1, final String a2) {
            super(Type.PROJECT, a1.name().toLowerCase() + "-" + a2);
            this.projectRole = a1;
            this.projectId = a2;
        }
        
        public ProjectRole getProjectRole() {
            /*SL:377*/return this.projectRole;
        }
        
        public String getProjectId() {
            /*SL:382*/return this.projectId;
        }
        
        public static final class ProjectRole extends StringEnumValue
        {
            private static final long serialVersionUID = -8360324311187914382L;
            private static final ApiFunction<String, ProjectRole> CONSTRUCTOR;
            private static final StringEnumType<ProjectRole> type;
            public static final ProjectRole OWNERS;
            public static final ProjectRole EDITORS;
            public static final ProjectRole VIEWERS;
            
            private ProjectRole(final String a1) {
                super(a1);
            }
            
            public static ProjectRole valueOfStrict(final String a1) {
                /*SL:349*/return (ProjectRole)ProjectRole.type.valueOfStrict(a1);
            }
            
            public static ProjectRole valueOf(final String a1) {
                /*SL:354*/return (ProjectRole)ProjectRole.type.valueOf(a1);
            }
            
            public static ProjectRole[] values() {
                /*SL:359*/return (ProjectRole[])ProjectRole.type.values();
            }
            
            static {
                CONSTRUCTOR = (ApiFunction)new ApiFunction<String, ProjectRole>() {
                    public ProjectRole apply(final String a1) {
                        /*SL:333*/return new ProjectRole(a1);
                    }
                };
                type = new StringEnumType((Class)ProjectRole.class, (ApiFunction)ProjectRole.CONSTRUCTOR);
                OWNERS = (ProjectRole)ProjectRole.type.createAndRegister("OWNERS");
                EDITORS = (ProjectRole)ProjectRole.type.createAndRegister("EDITORS");
                VIEWERS = (ProjectRole)ProjectRole.type.createAndRegister("VIEWERS");
            }
        }
    }
    
    public static final class RawEntity extends Entity
    {
        private static final long serialVersionUID = 3966205614223053950L;
        
        RawEntity(final String a1) {
            super(Type.UNKNOWN, a1);
        }
        
        @Override
        String toPb() {
            /*SL:396*/return this.getValue();
        }
    }
}
