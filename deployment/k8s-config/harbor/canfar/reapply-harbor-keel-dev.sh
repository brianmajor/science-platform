#!/bin/bash
helm --namespace cadc-harbor upgrade cadc-harbor bitnami/harbor -f values-keel-dev.yaml --version 16.4.6 --set postgresql.image.tag="11.15.0
