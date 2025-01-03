DROP TABLE IF EXISTS event_publication;
CREATE TABLE IF NOT EXISTS event_publication (
                                   id UUID PRIMARY KEY,
                                   event_type VARCHAR(455) NOT NULL,
                                   event_payload VARCHAR(1455) NOT NULL,
                                   publication_date TIMESTAMP NOT NULL,
                                   completion_date TIMESTAMP,
                                   serialized_event VARCHAR(1455) NOT NULL,
                                   event_publication_archive VARCHAR(455),
                                   listener_id VARCHAR(455) NOT NULL,
                                   status VARCHAR(20) NOT NULL DEFAULT 'PENDING'
);
DROP TABLE IF EXISTS event_publication_archive;
CREATE TABLE IF NOT EXISTS event_publication_archive (
                                   id UUID PRIMARY KEY,
                                   event_type VARCHAR(455) NOT NULL,
                                   event_payload VARCHAR(1455) NOT NULL,
                                   publication_date TIMESTAMP NOT NULL,
                                   completion_date TIMESTAMP,
                                   serialized_event VARCHAR(1455) NOT NULL,
                                   event_publication_id VARCHAR(455),
                                   listener_id VARCHAR(455) NOT NULL,
                                   status VARCHAR(20) NOT NULL DEFAULT 'PENDING'
);