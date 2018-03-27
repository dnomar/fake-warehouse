#!/bin/bash

#
# File: quick-dot-to-dot.sh
#
#   Invocation:   ./uml4dot.sh some-diag.u4d | dot -Tsvg -osome-diag.svg
#   Parameters are passed as-is to sed, so it behaves like sed
#
#   This sed script expands following keywords into their Graphviz dot representation:
#
#      actor, boundary, control, entity, and usecase
#
#   Syntax:  actor|boundary|control|entity|usecase <dot_node_name> ["<label>"] [<node_params>]
#     - unlike dot write <label> and <node_params> without brackets
#     - <label> must go between "
#     - <node_params> are added to the params declaration by the script
#
#   To split names into lines, use "_._"
#
#   Recommended source file header (imagescale=true avoids uneven images scaling):
#
#       digraph G {
#           rankdir="LR";
#           node     [fontsize=16, label="", shape=none, imagescale=true];
#           // ...
#       }
#
#

keywords="actor\|boundary\|control\|entity"
label_beg="shape=none, label=<<table border=\\\"0\"><tr><td><img src=\\\""
label_mid=".svg\\\"\\/><\\/td><\\/tr><tr><td>"
label_end="<\\/td><\\/tr><\\/table>>"

uc_kw="usecase"
uc_lbl_beg="shape=ellipse, label=\\\""
uc_lbl_mid=""
uc_lbl_end="\\\""

re_id="[_[:alnum:]]\+"
re_name="[^\\\"]*"

sed \
    -e "s/^\([[:space:]]*\)\(${keywords}\)\([[:space:]]\+\)\(${re_id}\)[[:space:]]*$/\1\3\4    [${label_beg}\2${label_mid}\4${label_end}\];/g" \
    -e t \
    -e "s/^\([[:space:]]*\)\(${keywords}\)\([[:space:]]\+\)\(${re_id}\)\([[:space:]]\+\)\([^\"[:space:]].*\)/\1\3\4\5\[\6, ${label_beg}\2${label_mid}\4${label_end}\];/g" \
    -e t \
    -e "s/^\([[:space:]]*\)\(${keywords}\)\([[:space:]]\+\)\(${re_id}\)\([[:space:]]\+\)\"\(${re_name}\)\"[[:space:]]*$/\1\3\4\5\[${label_beg}\2${label_mid}\6${label_end}\];/g" \
    -e t \
    -e "s/^\([[:space:]]*\)\(${keywords}\)\([[:space:]]\+\)\(${re_id}\)\([[:space:]]\+\)\"\(${re_name}\)\"\([[:space:]]\+\)\([^\"[:space:]].*\)/\1\3\4\5\[\8, ${label_beg}\2${label_mid}\6${label_end}\];/g" \
    -e t \
    -e "s/^\([[:space:]]*\)\(${uc_kw}\)\([[:space:]]\+\)\(${re_id}\)[[:space:]]*$/\1\3\4    [${uc_lbl_beg}\4${uc_lbl_end}\];/g" \
    -e t \
    -e "s/^\([[:space:]]*\)\(${uc_kw}\)\([[:space:]]\+\)\(${re_id}\)\([[:space:]]\+\)\([^\"[:space:]].*\)/\1\3\4\5\[\6, ${uc_lbl_beg}\4${uc_lbl_end}\];/g" \
    -e t \
    -e "s/^\([[:space:]]*\)\(${uc_kw}\)\([[:space:]]\+\)\(${re_id}\)\([[:space:]]\+\)\"\(${re_name}\)\"[[:space:]]*$/\1\3\4\5\[${uc_lbl_beg}\6${uc_lbl_end}\];/g" \
    -e t \
    -e "s/^\([[:space:]]*\)\(${uc_kw}\)\([[:space:]]\+\)\(${re_id}\)\([[:space:]]\+\)\"\(${re_name}\)\"\([[:space:]]\+\)\([^\"[:space:]].*\)/\1\3\4\5\[\8, ${uc_lbl_beg}\6${uc_lbl_end}\];/g" \
    $* \
    | sed -e "s/_\._/<br\/>/g" -e "/shape=ellipse/s/<br[\/]>/\\\\n/g"
#
# ------------------------------------------------------------------------------------------
# valid input
#
#    control op_print
#    control  op_plans_show      "presenta_._planes"
#    control  op_plans_show      "presenta_._planes"   
#    control  op_plans_show      "presenta planes"   
#    actor suscriptor
#    actor suscriptor   
#    actor suscriptor  "Cliente"
#    actor suscriptor  "Cliente"   id="clnt" 
#    actor suscriptor    id="sus"
#    actor administrador
#    boundary  dashboard
#    boundary  dashboard "M2M dash"
#    boundary  dashboard "M2M dash"   id="m2m"
#    boundary  dashboard  id="db"
#
#    usecase uc_print
#    usecase uc32
#    usecase uc32 "UC-32"
#    usecase uc_plans_show      "UC-18_._presentando_._planes"
#    usecase uc_clnt  "UC Cliente"   id="clnt" 
#    usecase ucdashboard
#    usecase ucdashboard "M2M dash"
#    usecase ucdashboard "M2M dash"   id="m2m"
#
