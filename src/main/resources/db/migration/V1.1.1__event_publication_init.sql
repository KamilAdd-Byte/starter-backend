CREATE TABLE event_publication (
                                   id UUID PRIMARY KEY,
                                   event_type VARCHAR(255) NOT NULL,
                                   event_payload TEXT NOT NULL,
                                   publication_date TIMESTAMP NOT NULL,
                                   completion_date TIMESTAMP,
                                   serialized_event VARCHAR(255) NOT NULL,
                                   event_publication_archive VARCHAR(255),
                                   listener_id VARCHAR(255) NOT NULL,
                                   status VARCHAR(20) NOT NULL DEFAULT 'PENDING'
);

CREATE TABLE event_publication_archive (
                                   id UUID PRIMARY KEY,
                                   event_type VARCHAR(255) NOT NULL,
                                   event_payload TEXT NOT NULL,
                                   publication_date TIMESTAMP NOT NULL,
                                   completion_date TIMESTAMP,
                                   serialized_event VARCHAR(255) NOT NULL,
                                   event_publication_id VARCHAR(255),
                                   listener_id VARCHAR(255) NOT NULL,
                                   status VARCHAR(20) NOT NULL DEFAULT 'PENDING'
);